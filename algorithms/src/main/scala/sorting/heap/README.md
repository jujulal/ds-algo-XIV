Heapsort is a comparison-based sorting algorithm, and is part of the selection sort family

![](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

```
function heapSort(a, count) is
     input:  an unordered array a of length count

     (first place a in max-heap order)
     heapify(a, count)

     end := count-1 //in languages with zero-based arrays the children are 2*i+1 and 2*i+2
     while end > 0 do
         (swap the root(maximum value) of the heap with the last element of the heap)
         swap(a[end], a[0])
         (decrease the size of the heap by one so that the previous max value will
         stay in its proper placement) 
         end := end - 1
         (put the heap back in max-heap order)
         siftDown(a, 0, end)
         

 function heapify(a, count) is
     (start is assigned the index in a of the last parent node)
     start := count / 2 - 1
     
     while start ≥ 0 do
         (sift down the node at index start to the proper place such that all nodes below
          the start index are in heap order)
         siftDown(a, start, count-1)
         start := start - 1
     (after sifting down the root all nodes/elements are in heap order)

 function siftDown(a, start, end) is
     input:  end represents the limit of how far down the heap
                   to sift.
     root := start

     while root * 2 + 1 ≤ end do    (While the root has at least one child)
         child := root * 2 + 1      (root*2 + 1 points to the left child)
         swap := root        (keeps track of child to swap with)
         (check if root is smaller than left child)
         if a[swap] < a[child]
             swap := child
         (check if right child exists, and if it's bigger than what we're currently swapping with)
         if child+1 ≤ end and a[swap] < a[child+1]
             swap := child + 1
         (check if we need to swap at all)
         if swap != root
             swap(a[root], a[swap])
             root := swap          (repeat to continue sifting down the child now)
         else
             return
```

[Lecture 4: Priority Queues, Sorting, and Heaps](https://drive.google.com/drive/folders/0B9FyLOsn9I34flNORy1DUjhidEdXejNoV0JpM1lpdjhsZ0hOVXZ2b0toZEkydV9tSUxZb2M)

time complexity
---------------


```
O(n logn)
```
