defmodule Kafka.Producer do
  require Logger

  @behaviour :erlkaf_producer_callbacks

  @topic "benchmark"

  def delivery_report(delivery_status, message) do
    :io.format("received delivery report: ~p ~n", [{delivery_status, message}])
    :ok
  end

  def create_producer() do
    :erlkaf.start()

    producer_config = [
      bootstrap_servers: "localhost:29093",
      delivery_report_only_error: false,
      delivery_report_callback: __MODULE__
    ]

    :ok = :erlkaf.create_producer(:client_producer, producer_config)
    :ok = :erlkaf.create_topic(:client_producer, @topic, request_required_acks: 1)
  end

  def produce(key, value) do
    :ok = :erlkaf.produce(:client_producer, @topic, key, value)
  end
end
