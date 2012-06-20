/*
 * http://projecteuler.net/problem=20
 *
 * Problem 20
 * 21 June 2002
 * --------------------------------------------------------
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 * --------------------------------------------------------
 */

def sumOfTheFactDigits(int num) {
  if (num < 1) return 0
  def fact = { n ->
    (n..1).toList().inject(1G){r, it -> r * it}
  }
  fact(num).toString().toList()*.toInteger().sum()
}

assert (0..100).collect {
  new Tuple(it, sumOfTheFactDigits(it))
}.last()[1] == 648


