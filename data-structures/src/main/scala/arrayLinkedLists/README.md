![](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/pix/linkedlist.bmp)

[LinkedList, wiki](https://en.wikipedia.org/wiki/Linked_list)

[LinkedLists, CMU](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html)

implementations
---------------

[Scala List(1, 2, 3) ](http://www.scala-lang.org/api/2.7.7/scala/List.html)

```
val zipcodes = List(43081, 43025, 43229, 98000)
val packageWeights = List[Number](1, 2.0, 33d, 0x1)
val priorities = List.range(1,10)
val packages = List.fill(3)("release-package")

List.tabulate(5)(n => n * n) // List(0, 1, 4, 9, 16)
```

**Operations**

```
val x = List(1,2,3,4,5,6,7,8,9,10)
val y = 0 :: x //pre-append

val z = x ::: y //merge
val z = List.concat(x, y)


x.foreach { println }

//filter
val evens = x.filter(a => a % 2 == 0)
val y = x.takeWhile(a => a < 6) // List(1, 2, 3, 4, 5)

//map
val y = x.map(a => a * 2)

//sorting
val y = x.sort(_ < _)
```

http://www.scala-lang.org/api/current/index.html#scala.collection.mutable.ListBuffer

[Scala Iterator](http://www.scala-lang.org/docu/files/collections-api/collections_43.html) - http://www.scala-lang.org/api/current/index.html#scala.collection.Iterator

http://www.scala-lang.org/api/2.7.7/scala/Iterable.html

[Java LinkedList, oracle](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)

INTV
----

[leetcode INTV](https://leetcode.com/tag/linked-list)

```
Reverse a singly linked list.
```

https://www.hackerrank.com/contests/dstest-1/challenges/character-game

https://github.com/felipecao/amazon-coding-exercises

```
Given a string, find the first non-repeating character in it. For example, if the input string is “Create Challenge”, 
then output should be ‘r’. If there is no non-repeating character, then output should be "-1"
```

[Find the first non-repeating character from a stream of characters](http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/)

```python
# A Python program to find first non-repeating character from
# a stream of characters

MAX_CHAR = 256

def findFirstNonRepeating():
	linkedList = [] * MAX_CHAR
	repeated = [False] * MAX_CHAR
     
        stream = "nepoleondyanamiteandnepoleondyanamitestream"
	for i in xrange(len(stream)):
		x = stream[i]
		print "Reading " + x + " from stream"

		if not repeated[ord(x)]:
			if not x in linkedList:
				linkedList.append(x)
			else:
				linkedList.remove(x)

		if len(linkedList) != 0:
			print "First non-repeating character so far is ",
			print str(linkedList[0])

findFirstNonRepeating()

```