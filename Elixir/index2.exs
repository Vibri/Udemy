if is_integer(12.2) do
  IO.puts "is integer"
else
  IO.puts "not an integer"
end

unless is_integer(12.2) do
  IO.puts "Not an integer"
end


case :hello do
  :world ->
    IO.puts "Hello world"
  :"hello" ->
    IO.puts "Hello there"
  _ ->
    IO.puts "This always comes if nothing else"
end

cond do
  9+1 == 12 ->
    IO.puts "not true"
  8-2 == 6 ->
    IO.puts "This should print out."
  true ->
    IO.puts "true"

end
