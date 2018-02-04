(ns time-in-words
  (:require [clojure.test :refer :all]
            [clojure.string :as str]))


;; 21:20

;; https://www.hackerrank.com/challenges/the-time-in-words/problem

;; Write a program which prints the time in words for the input given in the format mentioned above.

;; whiteboard
;; split with : -> get hrs and mins
;; hrs -> words (using a map)
;; mins to words -> using a map but 15 becomes quarter

;; now, concat hrs and mins
;; if (mins < 30) minsToWord minute(s) past hrsToWord
;; if (mins == 30) half past hrsToWord
;; if (mins > 30) (60 - mins)ToWord minute(s) to hrsToWord

(def num-to-word
  (hash-map
   :1  "one"
   :2  "two"
   :3  "three"
   :4  "four"
   :5  "five"
   :6  "six"
   :7  "seven"
   :8  "eight"
   :9  "nine"
   :10 "ten"
   :11 "eleven"
   :12 "twelve"
   :13 "thirteen"
   :14 "fourteen"
   :15 "fivteen"
   :16 "sixteen"
   :17 "seventeen"
   :18 "eighteen"
   :19 "ninteen"
   :20 "twenty"
   :21 "twenty one"
   :22 "twenty two"
   :23 "twenty three"
   :24 "twenty four"
   :25 "twenty five"
   :26 "twenty six"
   :27 "twenty seven"
   :28 "twenty eight"
   :29 "twenty nine"))

(defn to-mins [hrs mins]
  (let [hrs-to-word ((keyword (str hrs)) num-to-word)
        mins-to-str (str mins)
        to-mins     (- 60 mins)
        to-hrs      (rem (inc hrs) 12)]
    (if (= mins 0)
      (str hrs-to-word " o' clock")
      (if (= mins 1)
        (str ((keyword mins-to-str) num-to-word) " minute past " hrs-to-word)
        (if (= mins 15)
          (str "quarter past " hrs-to-word)
          (if (< mins 30)
            (str ((keyword mins-to-str) num-to-word) " minutes past " hrs-to-word)
            (if (= mins 30)
              (str "half past " hrs-to-word)
              (if (= mins 45)
                (str "quarter to " ((keyword (str (rem (inc hrs) 12))) num-to-word))
                (if (= to-mins 1)
                  (str ((keyword (str to-mins)) num-to-word) " minute to " to-hrs)
                  (str ((keyword (str to-mins)) num-to-word) " minutes to " ((keyword (str to-hrs)) num-to-word)))))))))))

(defn time-to-word [time]
  (let [t            (str/split time #":")
        hrs          (Integer/parseInt (first t))
        mins         (Integer/parseInt (last t))
        to-word      (to-mins hrs mins)]
    to-word))

(let [h_t (read-line)
      h   (Integer/parseInt h_t)]

  (let [m_t (read-line)
        m   (Integer/parseInt m_t)]))

(deftest "time to word"
         (is (= (time-to-word "8:00") "eight o'clock"))
         (is (= (time-to-word "8:01") "one minute past eight"))
         (is (= (time-to-word "8:10") "ten minutes past eight"))
         (is (= (time-to-word "8:15") "quarter past eight"))
         (is (= (time-to-word "8:30") "half past eight")))
