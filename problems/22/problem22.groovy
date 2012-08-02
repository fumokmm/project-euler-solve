/* http://projecteuler.net/problem=22
 * 
 * Using names.txt (*1 right click and 'Save Link/Target As...'),
 * a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list
 * to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list.
 * So, COLIN would obtain a score of 938  53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * (*1) http://projecteuler.net/project/names.txt
 */

//def url = 'http://projecteuler.net/project/names.txt'.toURL()
//def names = Eval.me("[${url.text}]").sort()
def names = Eval.me("[${new File('names.txt').text}]").sort()
assert names.indexOf('COLIN') == 937

Character.metaClass {
  getAlphabeticalValue = {
    delegate.toUpperCase() - 64
  }
}

String.metaClass {
  getAlphabeticalValue = {
    delegate.collect {
      (it as char).with {
        [!it.lowerCase, !it.upperCase].every() ?
          0 : it.alphabeticalValue
      }
    }.sum()
  }
}

assert 871198282 == names.inject([]) { r, i ->
  r << [idx: r.size() + 1, value: i]
}.collect {
  it.idx * it.value.alphabeticalValue
}.sum()
