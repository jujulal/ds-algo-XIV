
[Binary Tree](https://en.wikipedia.org/wiki/Binary_tree)
------------

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

[BST Complexity](http://stackoverflow.com/a/15586871/432903)
-------------

```
Insertion, deletion and searching in a binary search tree are:

O(N) in the worst case;
O(log(N)) in the average case.
```

[BST](https://www.cs.usfca.edu/~galles/visualization/BST.html)/ ordered binary tree
-------------------

```
a binary tree where each node has a Comparable key (and an associated value) and satisfies the restriction that 
the key in any node is larger than the keys in all nodes in that node's left subtree and smaller than the keys in 
all nodes in that node's right subtree.
```

Tree Operations
---------------

```
           item1
          /   \
        item2  item3
      /  \
   item4  item5
```

Tree traversal
--------------

[DFS](http://www.geeksforgeeks.org/618/)
--------

![](https://wcipeg.com/wiki/images/8/85/DFS.gif)

- [Pre-root order (root, left, right)](http://algoviz.org/OpenDSA/Books/OpenDSA/html/BinaryTreeTraversal.html#preorder-traversal)

```
item1, (item2, item4, item5), ... item3
```

- [In-root order](http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/)

```
(item4, item2, item5), ... item1, item3
```

- Post-root order

```
(item4, item5, item2), item3, ... item1
```

[BFS](https://en.wikipedia.org/wiki/Breadth-first_search#Example)
------

![](https://upload.wikimedia.org/wikipedia/commons/4/46/Animated_BFS.gif)

[B-Tree](https://en.wikipedia.org/wiki/B-tree) = generalization of a BST
-------------------------------------------------

![](https://upload.wikimedia.org/wikipedia/en/0/03/Btree_index.PNG)

```
a self-balancing tree DS that 
- keeps data sorted and allows searches, sequential access, insertions, and deletions 
in logarithmic time. 

The B-tree is a generalization of a BST in that a node can have more than two children

B-Tree analysis

	 Average          Worst case
Space	 O(n)	          O(n)
Search	 O(log n)	  O(log n)
Insert	 O(log n)	  O(log n)
Delete	 O(log n)	  O(log n)

```

[Fractal tree index](https://en.wikipedia.org/wiki/Fractal_tree_index) = a generalization of a BST
-----------------------

![](https://image.slidesharecdn.com/tokumxtalk-130717091709-phpapp02/95/introducing-tokumx-mongodb-with-fractal-tree-indexing-5-638.jpg)

```
a tree data structure that keeps data sorted and allows searches and sequential access 
in the same time as a B-tree but with insertions and deletions that are asymptotically faster 
than a B-tree. 

- Like a B-tree, a Fractal Tree index is a generalization of a BST in that a node can have more than 
two children. 
- Furthermore, unlike a B-tree, a Fractal Tree index has buffers at each node, 
which allow insertions, deletions and other changes to be stored in intermediate locations.
```

https://en.wikipedia.org/wiki/TokuMX

[Inverted index](https://en.wikipedia.org/wiki/Inverted_index)
----------------------------------------------------------------

```
an index data structure storing a mapping from content, such as words or numbers, to its locations 
in a database file, or in a document or a set of documents
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
