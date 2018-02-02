(use
 '[clojure.string :only (split triml)])

;; https://www.hackerrank.com/challenges/time-conversion/problem
;; https://www.glassdoor.com/Interview/Given-an-analog-clock-how-would-you-tell-the-angle-QTN_458562.htm

(defn am-clock [clock]
  (let [hms        (clojure.string/split clock #":")
        actual-hrs (Integer/parseInt (first hms))
        hrs        (if (= actual-hrs 12) "00" (first hms))
        mins       (second hms)
        secs       (clojure.string/join "" (drop-last 2 (last hms)))
        am-cl      (str hrs ":" mins ":" secs)]
    am-cl))

(defn pm-clock [clock]
  (let [hms        (clojure.string/split clock #":")
        actual-hrs (Integer/parseInt (first hms))
        hrs        (if (= actual-hrs 12) (first hms) (+ 12 actual-hrs))
        mins       (second hms)
        secs       (clojure.string/join "" (drop-last 2 (last hms)))
        pm-cl      (str hrs ":" mins ":" secs)]
    pm-cl))

(defn military-format [clock]
  (let [ampm (clojure.string/join "" (take-last 2 clock))]
    (if (= ampm "PM") (pm-clock clock) (am-clock clock))))

(let [s (read-line)]
  (println (military-format s)))

(military-format "00:00:00AM")
(military-format "07:05:45PM")
