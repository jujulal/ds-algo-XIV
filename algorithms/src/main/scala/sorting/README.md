[CS241: Data Structures and Algorithms II -- Lecture Notes: Sorting Algorithm, Dr. Fang Tang, California State Polytechnic University, Pomona](https://www.cpp.edu/~ftang/courses/CS241/notes/sorting.htm)

[2.4 Priority Queues, Robert Sedgewick and Kevin Wayne](http://algs4.cs.princeton.edu/24pq/)

[BigO cheatsheet](https://docs.google.com/document/d/1V3haCV7U3JL4NVdopZvQXoq84Zvea-GZvwDdRHQQ9TU/edit)

[Introduction to Algorithms (2005), by Prof. Erik Demaine Prof. Charles Leiserson, free itunes](https://itunes.apple.com/us/itunes-u/introduction-to-algorithms/id341597754)

INTV
----

https://www.hackerrank.com/domains/algorithms/arrays-and-sorting

https://leetcode.com/tag/sort/

1. [Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).](https://leetcode.com/problems/insert-interval/)

_You may assume that the intervals were initially sorted according to their start times._

```
Example 1:
Given intervals [1,3],[6,9] + [2,5] = [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16] + [4,9] = [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
```

```scala
case class Interval(start: Int, end: Int)

object MergeInterval {
    def insert(intervals:Seq[Interval], newInterval: Interval) : Seq[Interval] = {
        
    }
}
```

2. [Given an unsorted array, find the maximum difference between the successive elements in its sorted form.](https://leetcode.com/problems/maximum-gap/)

_Try to solve it in linear time/space.
Return 0 if the array contains less than 2 elements.
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range._


