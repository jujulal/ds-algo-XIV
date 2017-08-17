[Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm)
--------------

```
a search algorithm that finds the position of a target value within a sorted array
```

![](https://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_search_into_array.png)

http://quiz.geeksforgeeks.org/binary-search/
 
[Complexity](https://www.topcoder.com/community/data-science/data-science-tutorials/binary-search/)
-------------

```
Since each comparison binary search uses halves the search space, we can assert and easily prove 
that binary search will never use more than O(log N) comparisons to find the target value.

So, avg/worst case - O(logn)
```

http://interactivepython.org/runestone/static/pythonds/SortSearch/TheBinarySearch.html

alternatives
------------

Hash table
----------

takes O(1) to search by "search term"

Q. store and search movies and description

```
val movies = Map(
   "Easy Rider" -> Movie(name="Easy Rider", artists="Denis Hopper", released=new Date(1, 1, 1969)),
   "The Doors" -> Movie(name="The Doors", artists="Jim Morrision", released=new Date(1, 1, 1991))
)
```

BST
---
sort when new item is added, search would take O(n logn) using binary search 

tries
-----

Others
------

https://en.wikipedia.org/wiki/Vector_space_model
```
an algebraic model for representing text documents (and any objects, in general) as vectors of identifiers, 
such as, for example, index terms.
```

https://en.wikipedia.org/wiki/Standard_Boolean_model
```
based on Boolean logic and classical set theory in that both the documents to be searched and the user's query 
are conceived as sets of terms. Retrieval is based on whether or not the documents contain the query terms.
```

https://en.wikipedia.org/wiki/Inverted_index

```
Content -> Location
```

http://stackoverflow.com/a/32878318/432903

```
an index data structure storing a mapping from content( such as words or numbers) to its locations in a
database file, or in a document or a set of documents 

eg. tweet document text "Porcupine Tree is fucking amazing band" is indexed as

posting list -> document/file
[Porcupine] → somePostId
[Tree]      → somePostId
[is]        → somePostId
[fucking]   → somePostId
[amazing]   → somePostId
[band]      → somePostId
```

INTV
----

https://www.hackerrank.com/domains/algorithms/search

https://leetcode.com/tag/binary-search/