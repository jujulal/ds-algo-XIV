(ns matrix-traversal
  (:gen-class))

(defn displayPathtoPrincess [m grid]

  )

(defn -main []
  (let [m    (read-line)
        grid (dorun (take m (map #(seq (.toCharArray %)) (repeatedly #(read-line)))))]
    (displayPathtoPrincess m grid)))
