def sumOfTheFactDigits(int num) {
  if (num < 1) return 0
  def fact = { n ->
    (n..1).toList().inject(1G){r, it -> r * it}
  }
  fact(num).toString().toList()*.toInteger().sum()
}

println(
  (0..100).collect {
    new Tuple(it, sumOfTheFactDigits(it))
  }.last()[1]
)
