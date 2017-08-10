[What is Bucket sort/ Shuffle sort?](https://en.wikipedia.org/wiki/Bucket_sort)

- Bucket sort, or bin sort, is a sorting algorithm that works by distributing the elements of an array 
into a number of buckets. 

- Each bucket is then sorted individually, either using a different sorting algorithm, or 
by recursively applying the bucket sorting algorithm.

![](https://upload.wikimedia.org/wikipedia/commons/6/61/Bucket_sort_1.png)

eg. 

```

29, 25, 3, 45, 9, 37, 21, 43

 [0 - (max => 45)]
-------------------- => k => [0, 8], [9, 17], [18, 26], [27, 35], [36, 44], [45, 53] 
  elements => n(8)

```

[algorithm](http://jng.imagine27.com/index.php/2010-05-24-214230_clojure_bucket_sort.html)

```clojure
(defn bucket-sort
  "Runs in O(n) time."
  [array]
  (let [len (count array)
        mx (apply max array)
        bucket-size (inc (int (/ mx len)))
        buckets (reduce (fn [v n] (conj v [])) []
                        (range (+ bucket-size (/ mx bucket-size))))]
    (letfn [(distrib-nums [v n]
                          (let [ind (int (/ n bucket-size))
                                bucket (nth v ind)]
                            (assoc! v ind (conj bucket n))))]
      (let [pre-buckets (persistent!
                         (reduce distrib-nums (transient buckets) array))]
        (apply concat (map (fn [bucket]
                             (when (> (count bucket) 0)
                               (insertion-sort bucket))) pre-buckets))))))
```

time complexity
---------------
```
O(n + k)
```

Space complexity
----------------
```
O(n.k)
```

Top-down radix sort can be seen as a special case of bucket sort where both the range of values and the number of buckets is 
constrained to be a power of two.

refs
----

[ICS 161: Design and Analysis of Algorithms, 1996](https://www.ics.uci.edu/~eppstein/161/960123.html)
