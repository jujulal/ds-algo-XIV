(ns test
  (:require [clojure.test :refer :all]))

;; https://leetcode.com/problems/decode-string/description/
;; https://www.careercup.com/question?id=19300678
;; https://www.glassdoor.com/Interview/Given-a-string-12345-and-a-alphabet-to-number-mapping-like-a-1-b-2-y-25-z-26-write-a-code-to-find-number-of-possible-QTN_1184147.htm

;; https://leetcode.com/problems/decode-ways/description/
;; https://leetcode.com/problemset/all/?search=decode

(def decoder-map
  (hash-map
   :1  "a"
   :2  "b"
   :3  "c"
   :4  "d"
   :5  "e"
   :6  "f"
   :7  "g"
   :8  "h"
   :9  "i"
   :10 "j"
   :11 "k"
   :12 "l"
   :13 "m"
   :14 "n"
   :15 "o"
   :16 "p"
   :17 "q"
   :18 "r"
   :19 "s"
   :20 "t"
   :21 "u"
   :22 "v"
   :23 "w"
   :24 "x"
   :25 "y"
   :26 "z"))

(defn decode [data index decoded-value]
  (if (= index (.length data))
    (apply str decoded-value)
    (if (< (+ index 2) (.length data))
      (if (= (get data (+ index 2)) \#)
        (let [whole-encoded     (str (get data index) (get data (+ index 1)))
              decoded           ((keyword whole-encoded) decoder-map)
              new-decoded       (conj decoded-value decoded)]
          (decode data (+ index 3) new-decoded))

        (decode data (inc index)
                (conj decoded-value ((keyword (str (get data index))) decoder-map))))

      (decode data (inc index)
              (conj decoded-value ((keyword (str (get data index))) decoder-map))))))

(deftest decode-test
  (is (= "abc" (decode "123" 0 [])))
  (is (= "abcp" (decode "12316#" 0 [])))
  (is (= "abcpz" (decode "12316#26#" 0 []))))
