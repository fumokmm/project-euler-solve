=begin
http://projecteuler.net/problem=1

Problem 1
05 October 2001

If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9.
The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
=end

sum = (0...1000).find_all do |x|
  x % 3 == 0 or
  x % 5 == 0
end.inject(:+)

p sum # => 233168
