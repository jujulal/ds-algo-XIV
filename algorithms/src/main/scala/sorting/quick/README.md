[What is Quick sort?](http://algs4.cs.princeton.edu/23quicksort/)
---------------------

* inplace sort algo unlike [Merge sort](http://algs4.cs.princeton.edu/22mergesort/) which required additional space
* suitable for sorting big data volumes

```
- Choose a pivot value. 
    We take the value of the middle element as pivot value, but it can be any value, which is in range of sorted values, even if it doesn't present in the array.
- Partition. (INTV)
    Rearrange elements in such a way, that all elements lesser than the pivot go to the left part of the array and all elements greater than the pivot, go to the right part of the array. 
    Values equal to the pivot can stay in any part of the array. Notice, that array may be divided in non-equal parts.
- Sort both parts. 
    Apply quicksort algorithm recursively to the left and the right parts.

```

[Why is quick sort [O(n logn)] better than merge sort [O(n logn)]?](http://cs.stackexchange.com/a/10/17252)

 - Quicksort in particular [requires little additional space](http://stackoverflow.com/a/70631/432903) and exhibits good cache locality, 
   and this makes it faster than merge sort in many cases.
 - In addition, it’s very easy to avoid quicksort’s worst-case run time of O(n2) almost entirely 
   by using an appropriate choice of the pivot – such as picking it at random (this is an excellent strategy)
 
 
[quick-sort visual](http://visualgo.net/sorting)

![](https://www.cs.auckland.ac.nz/software/AlgAnim/fig/qsort_divide.gif)

[Lecture 04: Quicksort, Randomized Algorithms 4 of 23, MIT OpenCourseWare](https://www.youtube.com/watch?v=852wJdsgl2I&list=PL40361139FDD683CE)

[Lecture - 10 Quick Sort, Dr. Naveen Garg](https://www.youtube.com/watch?v=gtWw_8VvHjk&index=59&list=PL40361139FDD683CE)


[Time Comlexity analysis](https://en.wikipedia.org/wiki/Quicksort#Formal_analysis)
--------------------------

```

Best - O(n logn)
Avg  - O(n logn)
Worst - O(n2)

Worst Performance Condition: //http://stackoverflow.com/a/4022806/432903

When each time pivot chosen is 'greatest' or 'smallest' and this pattern repeats 

So for [1 3 5 4 2]

If pivots are chosen in order [1,2,3,4,5] ....... Or...... [5,4,3,2,1]

then the worst case running time is O(n*n)

```

[When does the worst case of Quicksort occur?](http://www.geeksforgeeks.org/when-does-the-worst-case-of-quicksort-occur/)

[Space complexity](https://en.wikipedia.org/wiki/Quicksort#Space_complexity)
------------------------

```
The in-place version of quicksort has a space complexity of O(log n), even in the worst case, 
when it is carefully implemented using the following strategies:

- in-place partitioning is used. This unstable partition requires O(1) space.

- After partitioning, the partition with the fewest elements is (recursively) sorted first, 
requiring at most O(log n) space. Then the other partition is sorted using tail recursion or iteration, 
which doesn't add to the call stack. This idea, as discussed above, was described by R. Sedgewick, 
and keeps the stack depth bounded by O(log n)
```

[Lecture - 22 Average case Analysis of Quicksort, Prof.Abhiram Ranade](https://www.youtube.com/watch?v=-kh9oFK8R7s)