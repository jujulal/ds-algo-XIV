[Array](https://en.wikipedia.org/wiki/Array_data_structure#Efficiency)/ scala.collection.immutable.Vector[A]
--------

```
 Arrays is a data structure consisting of a collection of elements.
```

```
 Vector is much like array. Operations on a vector offer the same big O as their counterparts on an array. 
 Like array, vector data is allocated in contiguous memory.
 
 Unlike array, which are always of a fixed size, Vector can be grown.
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

http://stackoverflow.com/a/16837342/432903

```
int a[]  = {2,100,2,3,4};

//for index, 0 => update index 2
int a[] = {2,100,-2,3,4};

//for index 1 => update index 100, leave it I guess as it is out of bound
int a[] = {2,100,-2,3,4};

//for index 2 => update index 2 which is alreay updated by someone => means there is duplicate
```

I'd rather use array bucketing [O(n) space] to get count of each element

https://www.careercup.com/question?id=5638261762424832
[Minimum number of swaps required for arranging pairs adjacent to each other](http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/)
[Algorithm to find smallest integer by swapping a pair of digits in given integer](http://stackoverflow.com/a/17175322/432903)