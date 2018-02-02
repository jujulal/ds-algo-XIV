(use
 '[clojure.string :only (split triml)])

;; https://www.hackerrank.com/challenges/diagonal-difference/problem

(defn abs [x] (max x (- x)))

(defn diag-vector [array size]
  (for [index (range size -1 -1)]
    [(.get (.get array index) index)
     (.get (.get array index) (- size index))]))

(defn diag-diff [array size]
  (abs (reduce + (map #(- (first %) (last %)) (diag-vector array size)))))

(let [n_t (read-line)
      n   (Integer/parseInt n_t)]

  (let [a    (for [a_temp (range n)] (map #(Integer/parseInt %) (split (read-line) #"\s+")))
        diff (diag-diff (doall a) (- n 1))]
    (println diff)))
