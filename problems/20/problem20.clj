(defn fact [n] 
  (loop [sum 1 n n]
    (if	(zero? n)
      sum
      (recur (* sum n) (dec n)))))

(def ans (apply +
		(map #(bigdec (str %))
		     (seq (str (fact 100M))))))
(println ans)
; => 648M
