(use
 '[clojure.string :only (split triml)])

(defn number-type [x] (if (> x 0) 1 (if (< x 0) -1 0)))

(defn count-nums [v n]
  (count (filter (fn [x] (= x n)) (map number-type v))))

(defn find-weight [n size]
  (format "%.6f" (float (/ n size))))

(defn display-weight [array size]
  (doseq [w (map (fn [x] (find-weight (count-nums array x) size)) [1 -1 0])] (println w)))

(let [n_t (read-line)
      n   (Integer/parseInt n_t)]

  (let [arr_temp (read-line)
        arr_t    (split arr_temp #"\s+")
        arr      (map #(Integer/parseInt %) arr_t)]

    (display-weight arr n)))
