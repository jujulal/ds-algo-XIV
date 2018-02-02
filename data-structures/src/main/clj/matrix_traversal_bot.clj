(ns solution
  (:gen-class))

(defn find-all-dirts [grid grid-size row col dirts-state]

  (if (and (= row (dec grid-size))(= col (dec grid-size)))

    (if (= (get (get grid row) col) "d") (conj dirts-state [row col]) dirts-state)

    (if (= (get (get grid row) col) "d")
      (conj dirts-state [row col])
      (if (< col (dec grid-size))
        (find-all-dirts grid grid-size row (inc col) dirts-state)
        (if (< row (dec grid-size))
          (find-all-dirts grid grid-size (inc row) 0 dirts-state))))
    )

  )

(defn nearest-dirt-to-clean [n r c board]
  (if (and (= r n) (= c n))))

(defn next_move [pos board])

(defn -main []
  (let [pos   (read-line)
        board (dorun (take 5 (map #(seq (.toCharArray %)) (repeatedly #(read-line)))))]
    (next-move pos board)))
