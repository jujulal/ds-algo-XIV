
Binary Tree
-----------

```
A binary tree is made of nodes, where each node contains a "left" pointer, a "right" pointer, and a data element

case class BinaryNode[T](
                          var data: T,
                          var left: BinaryNode[T],
                          var right: BinaryNode[T])
```

![](http://cslibrary.stanford.edu/110/binarytree.gif)

[Binary Trees, by Nick Parlante, stanford uni](http://cslibrary.stanford.edu/110/BinaryTrees.html)

[Binary Trees, Victor Adamchik, CMU](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html)

[BST](https://www.cs.usfca.edu/~galles/visualization/BST.html)/ ordered binary tree
-------------------

```
a binary tree where each node has a Comparable key (and an associated value) and satisfies the restriction that 
the key in any node is larger than the keys in all nodes in that node's left subtree and smaller than the keys in 
all nodes in that node's right subtree.
```

Tree Operations
---------------

traversal
DFS
- Pre-order (root, left, right)
- In-order
- Post-order

BFS

https://en.wikipedia.org/wiki/B-tree

```
a self-balancing tree DS that keeps data sorted and allows searches, sequential access, insertions, and deletions in logarithmic time. 

The B-tree is a generalization of a BST in that a node can have more than two children

B-Tree analysis

	 Average          Worst case
Space	 O(n)	          O(n)
Search	 O(log n)	  O(log n)
Insert	 O(log n)	  O(log n)
Delete	 O(log n)	  O(log n)

```

https://en.wikipedia.org/wiki/Inverted_index

```
an index data structure storing a mapping from content, such as words or numbers, to its locations in a database file, 
or in a document or a set of documents
```

Shortest Path
-------------

[Dijkstra's Shortest Path Algorithm, CS 312 Lecture 20](https://www.cs.cornell.edu/courses/cs312/2002sp/lectures/lec20/lec20.htm)

[Dijkstra wiki](https://en.wikipedia.org/wiki/Shortest_path_problem)

INTV
----

https://leetcode.com/tag/tree/

[100. Same Tree](https://leetcode.com/problems/same-tree/)

```
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
```