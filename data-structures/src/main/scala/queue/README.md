Queue/Stream
------------

```
A queue is a container of objects (a linear collection) that are inserted and removed 
according to the FIFO principle
```

![](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Stacks%20and%20Queues/pix/queue_abstraction1.bmp)

[Queues, Computer Science - 121, 2009, Carnegie Mellon Uni](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Stacks%20and%20Queues/Stacks%20and%20Queues.html)

https://docs.mongodb.com/manual/core/capped-collections/

[Queue, wiki](https://goo.gl/xA2UIu)


Impl
----

http://www.scala-lang.org/api/2.7.7/scala/collection/mutable/Queue.html

```
case class Event(type: String, properties: Map[String, String])

val events = Queue(Event(type: "planActivated", properties: Map("date" -> new Date())), 
                   Event(type: "planDeActivated", properties: Map("date" -> new Date())), 
                   Event(type: "planReActivated", properties: Map("date" -> new Date())))

```

[Scala Immutable Queues](http://www.scala-lang.org/docu/files/collections-api/collections_17.html)

http://www.warski.org/blog/2014/06/reactive-queue-with-akka-reactive-streams/

[Java Immutable Queue](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html)

[Java Blocking Queue](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html)
INTV
----

https://leetcode.com/tag/queue/

[363. Max Sum of Rectangle No Larger Than K  QuestionEditorial Solution](https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/)

```
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
```