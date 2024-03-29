import Config
config :iex, default_prompt: ">>>"
config :kv, :routing_table, [{?a..?z, node()}]

if config_env() == :prod do
  config :kv, :routing_table, [
    {?a..?m, :"foo@viktor-ThinkPad-T560"},
    {?n..?z, :"bar@viktor-ThinkPad-T560"}
  ]
end