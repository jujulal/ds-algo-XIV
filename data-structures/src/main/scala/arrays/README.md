[Array](https://en.wikipedia.org/wiki/Array_data_structure#Efficiency)/ scala.collection.immutable.Vector[A]
--------

```
 Arrays is a data structure consisting of a collection of elements.
```

Vector = growable Array

```
 Vector is much like array. Operations on a vector offer the same big O as their counterparts on an array. 
 Like array, vector data is allocated in contiguous memory.
 
 Unlike array, which are always of a fixed size, Vector can be grown.
```

[Where is array saved in memory in java?](http://stackoverflow.com/a/7015836/432903)/ [what does java array look like?](https://dzone.com/articles/what-does-java-array-look)

_In theory, the stack has a single pointer to a location in the heap that contains the array itself._

And you know, [Java heap lives in Primary Memory - RandomAccessMemory](http://stackoverflow.com/a/5276257/432903)

```scala
                                      // This array object is
                                      // stored on the HEAP.
val scores                            = new int[5]
// This reference (scores) is stored
// in a variable on the STACK.
```

[Cache Localities/Locality of reference and Strides](http://docs.cray.com/books/S-2315-50/html-S-2315-50/qmeblljm.html)
---------------------------------------------------------

```
There are two basic types of reference locality – temporal and spatial locality.

Temporal(time) locality
- refers to the reuse of specific data, and/or resources, within a relatively small time duration

Spatial(storage) locality
- refers to the use of data elements within relatively close storage locations
- eg. Sequential spatial locality - occurs when data elements are arranged and accessed linearly,
  such as, traversing the elements in a one-dimensional array.
```

[Array search(O(n)) vs LinkedList search(O(n)) in terms of Storage locality](https://stackoverflow.com/a/19064628/432903)

```
If an array is accessed sequentially, many processors will not only fetch the block containing the 
element, but will also prefetch subsequent blocks to minimize cycles spent waiting on cache misses.

Also, if the array elements are small enough, loading a block containing an element means 
the next element is likely in the same block.

eg. the sequence of LOAD addresses for a sequential array access is nice and predictable. 
eg, [1000, 1016, 1032, 1064] etc.

Unfortunately, for linked lists the pattern of LOADs is unpredictable from the processor's point of view. 
It doesn't know that when loading an element at address M_ADD1 that the next address is the contents of (M_ADD1 + 8).

eg. the LOAD addresses for LinkedList are very hard to predict the next address
eg. [1000, 3048, 5040, 7888] etc

```

[Array Data Structure, Computer Science 121, Fall 2009, Carnegie Mellon University](https://www.cs.cmu.edu/~./adamchik/15-121/lectures/Arrays/arrays.html)

[mutable.StringBuilder](http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html) vs [mutable.Thread-safe StringBuffer](http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html), INTV, 07-08-2016

INTV
----

https://leetcode.com/tag/array/

[33. Search in Rotated Sorted Array - O(logn) ](https://leetcode.com/problems/search-in-rotated-sorted-array/), CRACKING CODE INTV 11.3

```
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.


(defn search
   "search an element in rotated array"
   [nums, target]
   (0))   
```

solution : http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/

[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

```
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. 

Assume that there is only one duplicate number, find the duplicate one.

Note:
- You must not modify the array (assume the array is read only).
- You must use only constant, O(1) extra space.
- Your runtime complexity should be less than O(n2).
- There is only one duplicate number in the array, but it could be repeated more than once.


object Solution {
    def findDuplicate(nums: Array[Int]) : Int {
        0
    }
}

```

stupid solution to achieve O(n) time, 0 space

[Find duplicate element in array in time O(n)](http://stackoverflow.com/a/16837342/432903)
Can it be efficient for 1m records?

```scala
int a[]  = {2,100,2,3,4};

//for index, 0 => update index 2
int a[] = {2,100,-2,3,4};

//for index 1 => update index 100, leave it I guess as it is out of bound
int a[] = {2,100,-2,3,4};

//for index 2 => update index 2 which is alreay updated by someone => means there is duplicate
```

I'd rather use array bucketing [O(n) space] to get count of each element

[Given an array int a[]={2,5,1,9,3,7,2,8,9,3}, Find the max number that can be formed using swap operations](https://www.careercup.com/question?id=5638261762424832)

[Minimum number of swaps required for arranging pairs adjacent to each other](http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/)

[Algorithm to find smallest integer by swapping a pair of digits in given integer](http://stackoverflow.com/a/17175322/432903)
