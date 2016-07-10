
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

http://www.scala-lang.org/docu/files/collections-api/collections_17.html

https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html


INTV
----

https://leetcode.com/tag/queue/

https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
