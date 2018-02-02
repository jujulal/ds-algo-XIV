(require
 '[clojure.core.reducers :as r])

;; https://www.hackerrank.com/challenges/compare-the-triplets/problem

(defn winner [score1 score2]
  (let [scores (for [index (range 0 (.length score1))
                     :let  [x (get score1 index)
                            y (get score2 index)
                            xy (if (> x y) [1 0] (if (> y x) [0 1] [0 0]))]]
                 xy)
        fs     (reduce + (map (fn [x] (first x)) scores))
        ss     (reduce + (map (fn [x] (last x)) scores))]
    [fs ss]))

(winner [2 1 10] [3 9 1])

;;maximum
(defn maximum [prices index max]
  (if (= index (.length prices))
    max
    (let [current-max (if (> (get prices index) max) (get prices index) max)]
      (maximum prices (+ index 1) current-max))))
