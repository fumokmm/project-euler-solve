/*
Problem 358
12 November 2011

A cyclic number with n digits has a very interesting property:
When it is multiplied by 1, 2, 3, 4, ... n, all the products have exactly the same digits, in the same order, but rotated in a circular fashion!

The smallest cyclic number is the 6-digit number 142857 :
142857 × 1 = 142857
142857 × 2 = 285714
142857 × 3 = 428571
142857 × 4 = 571428
142857 × 5 = 714285
142857 × 6 = 857142

The next cyclic number is 0588235294117647 with 16 digits :
0588235294117647 × 1 = 0588235294117647
0588235294117647 × 2 = 1176470588235294
0588235294117647 × 3 = 1764705882352941
...
0588235294117647 × 16 = 9411764705882352

Note that for cyclic numbers, leading zeros are important.

There is only one cyclic number for which, the eleven leftmost digits are 00000000137 and the five rightmost digits are 56789 (i.e., it has the form 00000000137...56789 with an unknown number of digits in the middle). Find the sum of all its digits.
*/

def toCyclicNumber(digits) {
  def nines = ('9'*digits).toBigInteger()
  if (nines % (digits + 1) == 0) {
    (nines / (digits + 1)).toString().padLeft(digits, '0')
  } else {
    null
  }
}

'12345' ==~ /^12\d+5$/

/*
(1..10000).collect{
  [it, toCyclicNumber(it)]
}.findAll{
  ! it[1].contains('.')
}.findAll{
  it[1] ==~ /^00000000137\d+56789$/
}
*/

def printnum = {it.size() > 16 ? it[0..10] + '...' + it[-1..-5] : it}
int n = 1076106
for (int i in 1..1000) {
  def cyclicNum = toCyclicNumber(n)
  if (! cyclicNum) {
    print "$n: --> "
    println 'skip.'
    n++
    continue
  } else if (cyclicNum ==~ /^00000000137\d+56789$/) {
    print "$n: ${printnum(cyclicNum)} (${cyclicNum.size()}) --> "
    println 'match!'
    break
  } else {
    print "$n: ${printnum(cyclicNum)} (${cyclicNum.size()}) --> "
    println 'not match.'
    if (n > 16 && cyclicNum[0..10].toLong() < 137) {
      n = ((int) n / 2) 
    } else {
      n *= 2
    }
  }
}
