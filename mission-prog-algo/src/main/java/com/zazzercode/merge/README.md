merge sort
----------------

algorithm
----------

```

call mergeSort(0, number-1)
|
|__mergeSort(int low, int high)
   | if( low < high )
   |      call mergeSort(low, middle)
   |      call mergeSort(middle+1, high)
   |      call merge(low, middle, high)
   |___merge(int low, int middle, int high)

```

[algorithm](http://www.ccs.neu.edu/home/vkp/1201-sp03/Labs/Lab4/mergesort.gif)

log
---------

INFO: Before => [13, 10, 0, 13, 3]

mergeSort(0, 4)
---------------
```
check if 0 < 4, if not then the array is sorted
       Sort the left (0,4) side of the array
check if 0 < 2, if not then the array is sorted
       Sort the left (0,2) side of the array
check if 0 < 1, if not then the array is sorted
       Sort the left (0,1) side of the array
check if 0 < 0, if not then the array is sorted
       Sort the right side of the array for (1,1)
check if 1 < 1, if not then the array is sorted
Merge them both (0,0,1)
```

merge(0, 0, 1)
-----------
```
Copy both parts into the helper array
numbers : 13, 10, 0, 13, 3
helpers : 13, 10, 0, 0, 0

Copy the smallest values from either the left or the right side back  to the original array 
Copy the rest of the left side of the array into the target array
Sort the right side of the array for (2,2)
check if 2 < 2, if not then the array is sorted
Merge them both (0,1,2)
```

merge(0, 1, 2)
--------------------
```
Copy both parts into the helper array
numbers : 10, 13, 0, 13, 3
helpers : 10, 13, 0, 0, 0 
Copy the smallest values from either the left or the right side back  to the original array 
Copy the rest of the left side of the array into the target array
Sort the right side of the array for (3,4)
check if 3 < 4, if not then the array is sorted
Sort the left (3,4) side of the array
check if 3 < 3, if not then the array is sorted
Sort the right side of the array for (4,4)
check if 4 < 4, if not then the array is sorted
Merge them both (3,3,4)
```

merge(3, 3, 4)
------------------------
```
Copy both parts into the helper array
numbers : 0, 10, 13, 13, 3
helpers : 10, 13, 0, 13, 3
Copy the smallest values from either the left or the right side back  to the original array 
Copy the rest of the left side of the array into the target array
Merge them both (0,2,4)
```

merge(0, 2, 4)
------------------------
```
Copy both parts into the helper array
numbers : 0, 10, 13, 3, 13
helpers : 0, 10, 13, 3, 13
Copy the smallest values from either the left or the right side back  to the original array 
Copy the rest of the left side of the array into the target array
```

after merge
--------------------
```
May 12, 2014 1:05:06 PM com.zazzercode.BootTest testMergeSort
INFO: Mergesort time complexity (ms) => 3

May 12, 2014 1:05:06 PM com.zazzercode.BootTest testMergeSort
INFO: After => [0, 3, 10, 13, 13]
```

[MIT, 3. Insertion Sort, Merge Sort](http://youtu.be/Kg4bqzAqRBM?t=24m33s)



Complexity
---------------

[merge](http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/Gifs/img1A.gif)

[MIT, 3. Insertion Sort, Merge Sort](http://youtu.be/Kg4bqzAqRBM?t=33m12s)

