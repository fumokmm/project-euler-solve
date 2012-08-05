/* http://projecteuler.net/problem=4
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

Number.metaClass {
  isPalindromicNumber = {
    delegate.toString().with{ it == it.reverse() }
  }
  getDigits = {
    delegate.toString().size()
  }
}

class PalindromicNumbers implements Iterable {
  int n = 999*999
  int end = 100*100
  def digit3 = null
  @Override Iterator iterator() { [
    hasNext : { true },
    next : {
      if (digit3) {
        def r = digit3.head()
        digit3 = digit3.tail()
        return r
      }
      while (n > end) {
        if (n.palindromicNumber) {
          digit3 = (999..100).collect{ [n:n, d1:it, d2:n/it, result:n % it == 0] }.findAll{ it.result }
          if (digit3) {
            n--
            def r = digit3.head()
            digit3 = digit3.tail()
            return r
          }
        }
        n--
      }
    }
  ] as Iterator }
}

def result
new PalindromicNumbers().takeWhile{
  if (it.d1.digits == 3 && it.d2.digits == 3) {
    result = it
  }
  !result
}

assert result == [n:906609, d1:993, d2:913, result:true]
