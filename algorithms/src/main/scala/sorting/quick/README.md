[What is Quick sort?](http://algs4.cs.princeton.edu/23quicksort/)
---------------------

* inplace sort algo unlike [Merge sort](http://algs4.cs.princeton.edu/22mergesort/) which required additional space
* suitable for sorting big data volumes

```
- Choose a pivot value. 
    We take the value of the middle element as pivot value, but it can be any value, which is in range of sorted values, even if it doesn't present in the array.
- Partition. (INT)
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


Time Comlexity analysis
-----------------------

```

O(n logn)

```

[Lecture - 22 Average case Analysis of Quicksort, Prof.Abhiram Ranade](https://www.youtube.com/watch?v=-kh9oFK8R7s)