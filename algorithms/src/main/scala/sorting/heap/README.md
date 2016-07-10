
[What is Heap?](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html)
binary heap is a `complete binary tree` which satisfies the `heap ordering property`. 

The ordering can be one of two types:

 - **the min-heap property**: the value of **each node is >=** the **value of its parent**, with the minimum-value element at the root.
 - **the max-heap property**: the value of **each node is <=** the **value of its parent**, with the maximum-value element at the root.

[What is Heap sort?](http://web.cse.ohio-state.edu/software/2231/web-sw2/extras/slides/14.Heaps-Heapsort.pdf)

```
Heapsort is a comparison-based sorting algo, and is part of the selection sort family.

Heapsort is an in-place algorithm, but it is not a stable sort.

```

![](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

Algo
----

[The steps are:](https://en.wikipedia.org/wiki/Heapsort#Algorithm)

```
- Call the heapify() or buildMaxHeap() function on the list, this builds a heap 
from a list in O(n) operations.
- Swap the first element of the list with the final element. Decrease the considered range of the list by one.
- Call the siftDown() function on the list to sift the new first element to its appropriate index in the heap.
- Go to step (2) unless the considered range of the list is one element.
```

```clojure
defn heapSort[array count] is
     input:  an unordered array a of length count

     (first place array in max-heap order)
     heapify(array, count)

     end := count-1 //in languages with zero-based arrays the children are 2*i+1 and 2*i+2
     
     while end > 0 do
         (swap the root(maximum value) of the heap with the last element of the heap)
         swap(array[end], array[0])
         
         (decrease the size of the heap by one so that the previous max value will stay in its proper placement) 
         end := end - 1
         
         (put the heap back in max-heap order)
         siftDown(array, 0, end)
```
         
```
 defn heapify[array count] is
     (start is assigned the index in a of the last parent node)
     start := count / 2 - 1
     
     while start ≥ 0 do
         (sift down the node at index start to the proper place such that all nodes below the start index are in heap order)
         siftDown(array, start, count-1)
         start := start - 1
     (after sifting down the root all nodes/elements are in heap order)
```

```
 defn siftDown[array start end] is
     input:  end represents the limit of how far down the heap to sift.
     root := start

     while root * 2 + 1 ≤ end do    (While the root has at least one child)
         child := root * 2 + 1      (root*2 + 1 points to the left child)
         swap := root        (keeps track of child to swap with)
         (check if root is smaller than left child)
         if array[swap] < array[child]
             swap := child
             
         (check if right child exists, and if it's bigger than what we're currently swapping with)
         if child+1 ≤ end and array[swap] < array[child+1]
             swap := child + 1
             
         (check if we need to swap at all)
         if swap != root
             swap(array[root], array[swap])
             root := swap          (repeat to continue sifting down the child now)
         else
             return
```

[Lecture 4: Priority Queues, Sorting, and Heaps, Prof Ruby, 2015](https://drive.google.com/open?id=0B9FyLOsn9I34aV9XN2hUX1dNNU0)

time complexity
---------------


```

Best case performance	    - O(n log n)
Average case performance    - O(n log n)
Worst case performance	    - O(n log n)

Worst case space complexity - O(1) auxiliary
```


INTV
----

https://leetcode.com/tag/sort/