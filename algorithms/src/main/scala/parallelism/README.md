
[What is thread?](https://goo.gl/A1a4Zu)
-------------------------------------------

a thread of execution is the smallest sequence of programmed instructions that can be managed independently by a scheduler, 
which is typically a part of the OS.

Scheduling
------------

OS schedules threads either pre-emptively or co-operatively. 

| Pre-emptive multithreading                                                      | Co-operative multithreading  |
|---------------------------------------------------------------------------------|----------------------------|
| it allows the OS to determine when a context switch should occur.|               relies on the threads themselves to relinquish control once they are at a stopping point.   |
| disadvantage of preemptive multithreading is that the system may make a context switch at an inappropriate time, causing lock convoy, priority inversion or other negative effects, which may be avoided by cooperative multithreading.| This can create problems if a thread is waiting for a resource to become available.  |


Execution Model
---------------

- [a set of C-function library call](shttps://en.wikipedia.org/wiki/POSIX_Threads) - 
  % https://courses.cs.washington.edu/courses/cse471/02au/lectures/dyn1.pdf
  % http://ece-research.unm.edu/jimp/611/slides/chap4_3.html

- Java/Scala concurrency library java.util.concurrent/ scala.concurrent