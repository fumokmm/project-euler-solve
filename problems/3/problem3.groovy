/* http://projecteuler.net/problem=3
 *
 * Problem 3
 * 02 November 2001
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

// require Groovy v2.0 or upper!
import groovy.transform.CompileStatic

@CompileStatic
class Primes implements Iterator<BigInteger> {
  private BigInteger p = 1G
  @Override boolean hasNext() { true }
  @Override BigInteger next() {
    this.p = this.p.nextProbablePrime()
    this.p
  }
  @Override void remove() { throw new UnsupportedOperationException() }
  @Override String toString() { p }
}

@CompileStatic
List<BigInteger> toPrimeFactors(BigInteger num) {
  def rslt = []
  def primes = new Primes()
  while (num > 1) {
    BigInteger p = primes.next()
    while (num.mod(p) == 0G) {
      rslt << p
      num /= p
    }
  }
  rslt
}

assert toPrimeFactors(13195) == [5, 7, 13, 29]
assert toPrimeFactors(600851475143) == [71, 839, 1471, 6857]
//=> answer is 6857
