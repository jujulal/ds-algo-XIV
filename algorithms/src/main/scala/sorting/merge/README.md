[What is Merge sort?](http://www.ee.ryerson.ca/~courses/coe428/sorting/mergesort.html)

The merge sort algorithm:

 - Divide : Partition the list in half
 - Conquer: 
    - Merge sort the first half
    - Merge sort the second half
    - Merge both halves back together

![](https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif)

[time complexity](https://en.wikipedia.org/wiki/Merge_sort#Analysis)
---------------

_[Why is mergesort O(log n)?](http://programmers.stackexchange.com/a/297203/31060)_

```
Best  - O(n logn)  // n items * iterated log(n) times
Avg   - O(n logn)
Worst - O(n logn)
```

[Space complexity](http://stackoverflow.com/a/28641693/432903)
-------------------------------------------------------------

```
Merge Sort space complexity will always be O(n) as you have to store the elements somewhere
```

[Merge sort analysis, youtube, UCDavis](https://www.youtube.com/watch?v=yKp7dok7-Bg)

Refs
----

[MIT, 3. Insertion Sort, Merge Sort, MIT 6.006 Introduction to Algorithms, Fall 2011](http://youtu.be/Kg4bqzAqRBM?t=24m33s)

[How does the MapReduce sort algorithm work?](http://stackoverflow.com/a/1152903/432903)

```
TeraSort is a standard map/reduce sort, except for a custom partitioner that uses a sorted list of 
N − 1 sampled keys that define the key range for each reduce. In particular, all keys such that 
sample[i − 1] <= key < sample[i] are sent to reduce i. 

This guarantees that the output of reduce i are all less than the output of reduce i+1."
```

[http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/mergeSort.htm](http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/Gifs/img1A.gif)

[MIT, 3. Insertion Sort, Merge Sort, MIT 6.006 Introduction to Algorithms, Fall 2011](http://youtu.be/Kg4bqzAqRBM?t=33m12s)

https://github.com/ehiggs/spark-terasort

INTV
----

https://leetcode.com/tag/sort/
