
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

- [a set of C-function library call](shttps://en.wikipedia.org/wiki/POSIX_Threads)

    % [Static vs. dynamic scheduling](https://courses.cs.washington.edu/courses/cse471/02au/lectures/dyn1.pdf)
    
    % [Dynamic scheduling, scoreboarding](http://ece-research.unm.edu/jimp/611/slides/chap4_3.html)

    % [OpenMP Scheduling Loops](http://cs.umw.edu/~finlayson/class/fall14/cpsc425/notes/12-scheduling.html) - [CPSC 425: Parallel Computing, University of Mary Washington](http://cs.umw.edu/~finlayson/class/fall14/cpsc425/)
    
    % [Difference between static and dynamic schedule in openMP in C](http://stackoverflow.com/a/5864834/432903)
    
- Java/Scala concurrency library java.util.concurrent/ scala.concurrent

//Static vs Dynamic Loop scheduling in OpenMp

Static Loop Scheduling           | Dynamic Loop Scheduling | Guided Loop Scheduling 
----------------- | ------------------------- | --------------------------------------
All iterations are allocated to threads -> before they execute any iterations | Some of the iterations allocated to threads -> at start of execution. Threads that complete their iterations are eligible to get additional work. | Large chunks initially assigned to Threads, Additional chunks of progressively smaller size assigned dynamically to Threads as needed
has low overhead, but may have high load imbalance. | has higher overhead, but can reduce load imbalance. | 
# pragma omp parallel for private(tid) schedule(static, ChunkSize) | # pragma omp parallel for private(tid) schedule(dynamic, ChunkSize) | schedule(guided)

[Hyper-threading](https://en.wikipedia.org/wiki/Hyper-threading)

```
Architecturally, a processor with Hyper-Threading Technology consists of two logical processors per core, each of which has its own processor architectural state. 
Each logical processor can be individually halted, interrupted or directed to execute a specified thread, independently from the other logical processor sharing 
the same physical core.

$ sysctl -a | grep hw.
hw.ncpu: 8
hw.byteorder: 1234
hw.memsize: 17179869184
hw.activecpu: 8
hw.targettype: 
hw.physicalcpu: 4
hw.physicalcpu_max: 4
hw.logicalcpu: 8
hw.logicalcpu_max: 8
```

[Clock rate](https://en.wikipedia.org/wiki/Clock_rate)

```
The clock rate typically refers to the frequency at which a chip like a central processing unit (CPU), one core of a multi-core processor, is running and 
is used as an indicator of the processor's speed. It is measured in clock cycles per second or its equivalent, the SI unit hertz (Hz)

sysctl -n machdep.cpu.brand_string
Intel(R) Core(TM) i7-4770HQ CPU @ 2.20GHz
```

[Introduction to Parallel Computing, Blaise Barney, Lawrence Livermore National Laboratory](https://computing.llnl.gov/tutorials/parallel_comp/)

```
Load Balancing

Load balancing refers to the practice of distributing approximately equal amounts of work among tasks so that all tasks are kept busy all of the time. 
It can be considered a minimization of task idle time.

Load balancing is important to parallel programs for performance reasons. 
For example, if all tasks are subject to a barrier synchronization point, 
the slowest task will determine the overall performance.
```

[MultiThreading](https://goo.gl/CCb2wa)
--------------


[What is a multithreaded application, stackoverflow](http://stackoverflow.com/a/1313122/432903)

[1.3. Multithreading and Thread Synchronization](http://www.nakov.com/inetjava/lectures/part-1-sockets/InetJava-1.3-Multithreading.html)

```
multithreading is the ability of a central processing unit (CPU) or a single core in a multi-core processor to execute multiple processes or threads concurrently, 
appropriately supported by the operating system.
```