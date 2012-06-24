;; http://projecteuler.net/problem=1
;;
;; Problem 1
;; 05 October 2001
;;
;; If we list all the natural numbers below 10 that are multiples of 3 or 5,
;; we get 3, 5, 6 and 9.
;; The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn sum-of-mul-3or5-below [n]
  (->> (range 1 n)
       (filter #(or (zero? (rem % 3))
		    (zero? (rem % 5))))))

(println
 (apply + (sum-of-mul-3or5-below 1000)))

;=> 233168