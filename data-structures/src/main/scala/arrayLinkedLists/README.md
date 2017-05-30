
[LinkedList](https://en.wikipedia.org/wiki/Linked_list)
-------------

```
a linear collection of data elements, called nodes, pointing to the next node by means of a pointer.
```

![](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/pix/linkedlist.bmp)

[LinkedLists, CMU](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html)

implementations
---------------

[Scala immutable.List(1, 2, 3) / lazy immutable.Stream](http://www.scala-lang.org/api/2.7.7/scala/List.html)

```
val zipcodes = List(43081, 43025, 43229, 98000)
val packageWeights = List[Number](1, 2.0, 33d, 0x1)
val priorities = List.range(1,10)
val packages = List.fill(3)("release-package")

List.tabulate(5)(n => n * n) // List(0, 1, 4, 9, 16)
```

[Clojure LinkedList](https://news.ycombinator.com/item?id=7076599)

http://hypirion.com/musings/understanding-persistent-vector-pt-1

```clojure
(deftype Node [car cdr])

=> (def node (Node. "picked" nil))
=> (.car node)
"picked"
=> (.cdr node)
nil

=> (def item-life (Node. "picked" (Node. "inducted" (Node. "packed" nil))))
=> (.car (.cdr item-life))
"inducted"
```

[car= first/ cdr= next, taken from LISP](https://www.gnu.org/software/emacs/manual/html_node/eintr/car-_0026-cdr.html)

**Operations**

```
val currentSales = List(1,2,3,4,5,6,7,8,9,10)
val previousSales = 0 :: currentSales //pre-append

val allSales = currentSales ::: previousSales //merge
val allSales = List.concat(currentSales, previousSales)
```

```
currentSales.foreach { println }

//filter
val evenSales = currentSales.filter(s => s % 2 == 0)
val filterSales = currentSales.takeWhile(s => s < 6) // List(1, 2, 3, 4, 5)

//map
val increaseSales = currentSales.map(s => s * 2)

//sorting
val sortSales = currentSales.sort(_ < _)
```

[scala Iterable](http://www.scala-lang.org/api/2.7.7/scala/Iterable.html)

```
provide a method elements() which returns an iterator over all the elements contained in the collection

Typically, an Iterable should be able to produce any number of valid Iterators.

trait Iterable[T]{
    def iterator() : Iterator[T] 
}
```

[Scala Iterator](http://www.scala-lang.org/docu/files/collections-api/collections_43.html) - [scala.collection.Iterator](http://www.scala-lang.org/api/current/index.html#scala.collection.Iterator)

```
a way to access the elements of a collection one by one

trait Iterator[E] {
    def hasNext() : Boolean
    def next() : E
    def remove(): Unit
}

val it = Iterator("package-1", "package-2", "package-3", "package-4")
assert(it.hasNext() == true)
assert(it.next() == "package-1")
```

[scala.List](http://www.scala-lang.org/api/2.7.1/scala/List.html)/ [scala.collection.mutable.ListBuffer](http://www.scala-lang.org/api/current/index.html#scala.collection.mutable.ListBuffer)

[Java LinkedList, oracle](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)

Java [Iterator(thread-safe)](http://stackoverflow.com/a/13081850/432903) vs [Enumeration](https://docs.oracle.com/javase/7/docs/api/java/util/Enumeration.html), INTV JWN, 2016 

time analysis
-------------

operation | complexity
----------|--------------
insert | O(1) => iff pointer to insert is known, otherwise O(n)
search | O(n)
remove | search time + O(1)

[LinkedList cache locality/ 5 reasons to be Anti-LinkedList](http://highscalability.com/blog/2013/5/22/strategy-stop-using-linked-lists.html)

```

http://www.futurechips.org/thoughts-for-researchers/quick-post-linked-lists.html#more-818

In The Secret To 10 Million Concurrent Connections one of the important strategies is not scribbling 
data all over memory via pointers because following pointers increases cache misses which reduces perf.

0. They reduce the benefit of out-of-order execution.
1. They throw off hardware prefetching.
2. They reduce DRAM and TLB locality.
3. They cannot leverage Single instruction, multiple data - [SIMD](https://en.wikipedia.org/wiki/SIMD).
4. They are harder to send to GPUs.
 
```

space analysis
--------------

```
O(n)
```

INTV
----

[leetcode INTV](https://leetcode.com/tag/linked-list)

[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/), JWN

```
Reverse a Singly LinkedList.
```

Solution - http://www.programcreek.com/2014/05/leetcode-reverse-linked-list-java/

[Find the first non-repeating character from a stream of characters](http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/)

https://www.hackerrank.com/contests/dstest-1/challenges/character-game

https://github.com/felipecao/amazon-coding-exercises

```
Given a string, find the first non-repeating character in it. For example, if the input string is “Create Challenge”, 
then output should be ‘r’. If there is no non-repeating character, then output should be "-1"
```

https://www.hackerrank.com/contests/dstest-1/challenges/character-game

[Find the first non-repeating character in a stream of characters?](https://www.careercup.com/question?id=4569644446777344)

- use linkedList and array

```python
# A Python program to find first non-repeating character from
# a stream of characters

MAX_CHAR = 256

def findFirstNonRepeating():
	nonRepeatedList = [] * MAX_CHAR
	repeated = [False] * MAX_CHAR
     
        stream = "nepoleondyanamiteandnepoleondyanamitestream"
	for i in xrange(len(stream)):
		character = stream[i]
		print "Reading " + character + " from stream"

		if not repeated[ord(character)]:
			if not character in nonRepeatedList:
				nonRepeatedList.append(character)
			else:
				nonRepeatedList.remove(character)

		if len(nonRepeatedList) != 0:
			print "First non-repeating character so far is ",
			print str(nonRepeatedList[0])

findFirstNonRepeating()

```

[Given two linked lists, find the node at which they merge.](https://www.careercup.com/question?id=12842661), [offerup, 16](https://www.glassdoor.com/Interview/OfferUp-Senior-Software-Engineer-Interview-Questions-EI_IE854884.0,7_KO8,32.htm)

[Given a very long list of URLs, find the first URL which is unique ( occurred exactly once ).](https://www.careercup.com/question?id=11856466) 

_I gave a O(n) extra space and O(2n) time solution, but he was expecting O(n) time, one traversal._

```
you can solve this in O(n) using a combination of trie and linked list. 

The leaf node of a trie maintains a flag to record duplicate urls and pointer to a node in a link list. 

* If you encounter a new url, 
add a node to the head of the linked list and set the pointer in the trie. 
Whenever you encounter a url that is already in the trie, 
if the flag is not set, then set the flag, delete the node from the linked list and set pointer to null. 

If the flag is already set, 
then ignore and read the next url. 

After processing all the urls, the link list should only contain the unique urls and the node at the tail is the first 
unique url from the list. 

For n urls, inserting urls into the trie in O(n) and link list operations are all constant time. 
The node could just keep the index of the url in the list so that we don't have to store urls in the link list as well.
```
