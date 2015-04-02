#!/bin/ruby
# Head ends here
def display_path_to_princess(n, grid)
  row_move = "UP\n"
  column_move = "LEFT\n"
  my_position = n / 2
  princess_position = get_princess_position grid

  # Define the correct row move
  if my_position < princess_position[:row]
    row_move = "DOWN\n"
  end

  # Define the correct column move
  if my_position < princess_position[:column]
    column_move = "RIGHT\n"
  end

  # Move to the correct Row
  puts row_move * (my_position - princess_position[:row]).abs
  puts column_move * (my_position - princess_position[:column]).abs
end

def get_princess_position(grid)
  column, row = 0
  line_count = 0
  grid.each do |line|
    if line.index('p')
      column = line.index('p')
      row = line_count
    end
    line_count += 1
  end

  { column:  column, row: row }
end

# Tail starts here
m = gets.to_i

grid = Array.new(m)

(0...m).each do |i|
  grid[i] = gets.strip
end

display_path_to_princess(m, grid)
