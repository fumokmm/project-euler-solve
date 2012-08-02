;; http://projecteuler.net/problem=7
;;
;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
;; we can see that the 6th prime is 13.
;; What is the 10 001st prime number?

(defn nextPrime [p] (.nextProbablePrime p))

(def primes (iterate nextPrime (BigInteger. "2")))

(println (nth primes 10000)) ; => 104743
