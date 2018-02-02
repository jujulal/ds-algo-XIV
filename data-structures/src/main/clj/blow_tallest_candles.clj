(use
 '[clojure.string :only (split triml)])

;; https://www.hackerrank.com/challenges/birthday-cake-candles/problem

(defn possible-candles [age candles]
  (reverse (sort candles)))

(defn blowable-candles [age available-candles]
  (let [candles (possible-candles age available-candles)
        candle  (first candles)]
    (count (filter #(= % candle) candles))))

(let [n_t (read-line)
      n   (Integer/parseInt n_t)]

  (let [ar_temp (read-line)
        ar_t    (split ar_temp #"\s+")
        ar      (map #(Integer/parseInt %) ar_t)]
    (println (blowable-candles n ar))))
