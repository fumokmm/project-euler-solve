;; http://projecteuler.net/problem=20
;;
;; Problem 20
;; 21 June 2002
;;
;; n! means n × (n − 1) × ... × 3 × 2 × 1
;;
;; For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
;; and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
;;
;; Find the sum of the digits in the number 100!

(defn fact [n] 
  (loop [sum 1 n n]
    (if	(zero? n)
      sum
      (recur (* sum n) (dec n)))))

(defn fact-sum [n]
  (apply +
	 (map #(bigdec (str %))
	      (seq (str (fact (bigdec n)))))))

(println (fact-sum 100M))

; => 648M
