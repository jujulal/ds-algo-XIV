[Synchronous parallelism](https://goo.gl/mf05u4)
----------------------------------------------------------------------------------

In parallel computing, a barrier is a type of synchronization method. 

A barrier (for a group of threads/processes) means any thread/process must stop at this point 
and cannot proceed until all other threads/processes reach this barrier.

[Parallel Programming With Barrier Synchronization, JVM](http://blogs.sourceallies.com/2012/03/parallel-programming-with-barrier-synchronization/)

https://cs.anu.edu.au/courses/comp8320/lectures/aux/comp422-Lecture21-Barriers.pdf

http://osl.cs.illinois.edu/media/papers/karmani-2009-barrier_synchronization_pattern.pdf

http://www.cs.utah.edu/~mhall/cs4961f11/CS4961-L12.pdf


http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CyclicBarrier.html

http://stackoverflow.com/a/5460822/432903

[JVM concurrency: Countdown latch vs Cyclic barrier](http://stackoverflow.com/a/4168861/432903)

- A CyclicBarrier is useful for more complex co-ordination tasks. An example of such a thing would be parallel computation - where multiple subtasks are involved in the computation - kind of like MapReduce.