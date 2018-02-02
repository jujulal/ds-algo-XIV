(use '[clojure.string :only (split triml)])

;; https://www.hackerrank.com/challenges/staircase/problem

(defn repeat-times [x char] (clojure.string/join "" (take x (repeat char))))

(defn stair-case-step [n size]
  (let [y (- size n)] (str (repeat-times y " ") (repeat-times n "#"))))

(defn stair-case [steps]
  (clojure.string/join "\n" (map #(stair-case-step % steps) (range 1 (+ steps 1)))))

(let [n_t (read-line)
      n (Integer/parseInt n_t)]
  (println (stair-case n)))
