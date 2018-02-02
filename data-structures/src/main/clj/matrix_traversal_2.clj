(ns solution
  (:gen-class))


;; https://www.hackerrank.com/challenges/saveprincess2

(defn find-princess [board r c]
  (let [char      (.charAt (.get board r) c)
        princess? (= char \p)]
    (if princess?
      [r c]
      (if (< c (- (.length board) 1))
        (find-princess board r (+ c 1))
        (find-princess board (+ r 1) 0)))))

(defn guard-is-up? [guard-r princess-position]
  (< guard-r (first princess-position)))

(defn guard-is-down? [guard-r princess-position]
  (> guard-r (first princess-position)))

(defn guard-is-right? [guard-c princess-position]
  (> guard-c (last princess-position)))

(defn guard-is-left? [guard-c princess-position]
  (< guard-c (last princess-position)))

(defn nextMove [n guard-r guard-c board]
  (let [princess-position (find-princess board 0 0)
        guard-position    [guard-r guard-c]
        move              (if (guard-is-right? guard-c princess-position)
                            "LEFT"
                            (if (guard-is-left? guard-c princess-position)
                              "RIGHT"
                              (if (guard-is-up? guard-r princess-position)
                                "DOWN"
                                (if (guard-is-down? guard-r princess-position)
                                  "UP"
                                  "RIGHT THERE"))))]
    move))

(defn -main []
  (let [n     (read-line)
        r     (read-line)
        c     (read-line)
        board (dorun (take n (map #(seq (.toCharArray %)) (repeatedly #(read-line)))))]
    (nextMove n r c board)))


(nextMove 3 1 1 ["---" "p--" "---"])
(nextMove 5 3 0 ["-----" "-----" "-----" "m----" "---p-"])