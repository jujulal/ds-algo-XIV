
[What is thread?](https://goo.gl/A1a4Zu)
-------------------------------------------

a thread of execution is the smallest sequence of programmed instructions that can be managed 
independently by a scheduler, which is typically a part of the OS.

Scheduling
------------

OS schedules threads either pre-emptively or co-operatively. 

| Pre-emptive multithreading                                                      | Co-operative multithreading  |
|---------------------------------------------------------------------------------|----------------------------|
| it allows the OS to determine when a context switch should occur.|               relies on the threads themselves to relinquish control once they are at a stopping point.   |
| disadvantage of preemptive multithreading is that the system may make a context switch at an inappropriate time, causing lock convoy, priority inversion or other negative effects, which may be avoided by cooperative multithreading.| This can create problems if a thread is waiting for a resource to become available.  |

[Normally use preemptive. If you find your design has a lot of thread-switching overhead, cooperative threads would be a possible optimization.](https://stackoverflow.com/a/4147474/432903)

Execution Model
---------------

- [a set of C-function library call/ posix_thread](https://en.wikipedia.org/wiki/POSIX_Threads)

    % [Static vs. dynamic scheduling](https://courses.cs.washington.edu/courses/cse471/02au/lectures/dyn1.pdf)
    
    % [Dynamic scheduling, scoreboarding](http://ece-research.unm.edu/jimp/611/slides/chap4_3.html)

    % [OpenMP Scheduling Loops](http://cs.umw.edu/~finlayson/class/fall14/cpsc425/notes/12-scheduling.html) - [CPSC 425: Parallel Computing, University of Mary Washington](http://cs.umw.edu/~finlayson/class/fall14/cpsc425/)
    
    % [Difference between static and dynamic schedule in openMP in C](http://stackoverflow.com/a/5864834/432903)
    
- scalac/javac concurrency library `java.util.concurrent`/ `scala.concurrent`

//Static vs Dynamic Loop scheduling in OpenMp

Static Loop Scheduling           | Dynamic Loop Scheduling | Guided Loop Scheduling 
----------------- | ------------------------- | --------------------------------------
|All iterations are allocated to threads -> before they execute any iterations | Some of the iterations allocated to threads -> at start of execution. Threads that complete their iterations are eligible to get additional work. | Large chunks initially assigned to Threads, Additional chunks of progressively smaller size assigned dynamically to Threads as needed
| has low overhead, but may have high load imbalance. | has higher overhead, but can reduce load imbalance. | 
| # pragma omp parallel for private(tid) schedule(static, ChunkSize) | # pragma omp parallel for private(tid) schedule(dynamic, ChunkSize) | schedule(guided)


[Thread states](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html) JWN, 07-2016
--------------

| state        | description  |
|--------------| ------------ |
|NEW           | A thread that has not yet started is in this state. |
|RUNNABLE      | A thread executing in the Java virtual machine is in this state.     |
|              |                                                                      |
|BLOCKED       | A thread that is blocked waiting for a monitor lock is in this state. |
|WAITING       | A thread that is waiting indefinitely for another thread to perform a particular action is in this state. |
|              |            |
|TIMED_WAITING | A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.|
| TERMINATED   | A thread that has exited is in this state.|


[Where is Thread Object created? Stack or JVM Heap Memory?](http://stackoverflow.com/a/19433994/432903)

```
val processor = new Thread() //new means always in heap memory
```

![](https://i.stack.imgur.com/kKDL2.gif)

[Why do threads share the heap space?](http://stackoverflow.com/a/3321554/432903)

```
Because otherwise they would be processes. That is the whole idea of threads, to share memory.
```

[How to catch an Exception from a thread (in JVM)](http://stackoverflow.com/questions/6546193/how-to-catch-an-exception-from-a-thread), JWN 2016

http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.UncaughtExceptionHandler.html

```scala
val shipOrders = new Thread() {
    def run() {
        
        println("Shipping ...")
        try {
            Thread.sleep(1000)
        } catch (InterruptedException e) {
            println("Interrupted.")
        }
        
        println("Shipping exception ...")
        throw new RuntimeException("Items missing in the package.")
    }
}

shipOrders.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                                           def uncaughtException(th: Thread, th: Throwable) {
                                               println("Error shipping orders : " + th)
                                           }
                                       })
shipOrders.start()
```

[sleep vs wait](http://stackoverflow.com/q/1036754/432903) JWN 07-2016

.sleep | .notify(.publish)/ .wait(.subscribe)/ Observer pattern in OO
-------|----------------
sleep() sends the Thread to sleep as it was before, it just packs the context and stops executing for a predefined time. | wait(), on the contrary, is a thread (or message) synchronization mechanism that allows you to notify a Thread of which you have no stored reference (nor care). 
So in order to wake it up before the due time, you need to know the Thread reference. This is not a common situation in a multi-threaded environment. It's mostly used for time-synchronization (e.g. wake in exactly 3.5 seconds) and/or hard-coded fairness (just sleep for a while and let others threads work). | You can think of it as a publish-subscribe pattern (wait == subscribe and notify() == publish). Basically using notify() you are sending a message (that might even not be received at all and normally you don't care).
To sum up, you normally use sleep() for time-syncronization | and wait() for multi-thread-synchronization.
In sleep() the thread stops working for the specified duration. | In wait() the thread stops working until the object being waited-on is notified, generally by other threads.

[Runnable.run(method call) vs Thread.start(start a thread)](http://stackoverflow.com/a/8579702/432903)
--------------

```
Runnable.run() is executed on the calling thread, just like any other method call. 

Thread.start() is required to actually create a new thread so that the runnable's run method is executed in parallel
```

[Shutting down threads cleanly](http://www.javaspecialists.eu/archive/Issue056.html)

[Why Are Thread.stop, Thread.suspend, Thread.resume and Runtime.runFinalizersOnExit Deprecated?](http://docs.oracle.com/javase/1.5.0/docs/guide/misc/threadPrimitiveDeprecation.html)

http://stackoverflow.com/a/3194618/432903

```scala

   val processor = new Thread(new Runnable(){
        
        override def run() {
            while(!Thread.currentThread().isInterrupted()){
                // do stuff         
            }   
        }})
    t.start()

    // Sleep a second, and then interrupt
    try {
        Thread.sleep(1000);
    } catch { 
        case e: InterruptedException => println("Processor is interrupted")
    }
    t.interrupt()
```

[Hyper-threading](https://en.wikipedia.org/wiki/Hyper-threading)
----------------

```
Architecturally, a processor with Hyper-Threading Technology consists of two logical processors per core, 
each of which has its own processor architectural state. 

Each logical processor can be individually halted, interrupted or directed to execute a specified thread, 
independently from the other logical processor sharing the same physical core.

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
The clock rate typically refers to the frequency at which a chip like a central processing unit (CPU),
one core ofa multi-core processor, is running and is used as an indicator of the processor's speed.

It is measured inclock cycles per second or its equivalent, the SI unit hertz (Hz)

sysctl -n machdep.cpu.brand_string
Intel(R) Core(TM) i7-4770HQ CPU @ 2.20GHz
```

[Introduction to Parallel Computing, Blaise Barney, Lawrence Livermore National Laboratory](https://computing.llnl.gov/tutorials/parallel_comp/)

```
Load Balancing

Load balancing refers to the practice of distributing approximately equal amounts of work among tasks so that
all tasksare kept busy all of the time.

It can be considered a minimization of task idle time.

Load balancing is important to parallel programs for performance reasons. 
For example, if all tasks are subject to a barrier synchronization point, 
the slowest task will determine the overall performance.
```

[MultiThreading](https://goo.gl/CCb2wa), HUM 07-2016
--------------------------------------------------------


[What is a multithreaded application, stackoverflow](http://stackoverflow.com/a/1313122/432903)

```
a single process can have many different "functions" executing concurrently, allowing the app 
to better use the available hardware (multiple cores/processors). 

Threads can communicate between them (they have shared 
memory), but its a hard problem to have every thread behave well with others when accesing shared objects/memory.
```

[1.3. Multithreading and Thread Synchronization](http://www.nakov.com/inetjava/lectures/part-1-sockets/InetJava-1.3-Multithreading.html)

```
multithreading is the ability of a CPU or a single core in a multi-core processor to execute multiple processes 
or threads concurrently, appropriately supported by the operating system.
```

[Dead lock](https://en.wikipedia.org/wiki/Deadlock)
---------------------------------------------------

```
In concurrent computing, a deadlock occurs when two competing actions wait for the other to finish, 
and thus neither ever does.
```


[Deadlock example](http://stackoverflow.com/a/34520/432903)

```
Process1     ---> locks table1
Process1 & 2 ---> want to process table2
Process2     ---> wins lock on table2     <--- Process1 is waiting
             ---> wants to process table1 <---- locked by Process1
             ---> waits in table2
```

[Why is Node.js single threaded?](http://stackoverflow.com/a/17959746/432903), [What is heck is EventLoop? - The JavaScript Event Loop: Explained](http://blog.carbonfive.com/2013/10/27/the-javascript-event-loop-explained/) sharethis, 2015

https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop

https://en.wikipedia.org/wiki/Event_loop

```
the event loop, message dispatcher, message loop, message pump, or run loop is a programming construct that
waits for and dispatches events or messages in a program.
```

![](http://blog.carbonfive.com/wp-content/uploads/2013/10/event-loop.png)

```
The issue with the "one thread per request" model for a server is that they don't scale well for several
scenarios compared to the event loop thread model.

Typically, in I/O intensive scenarios the requests spend most of the time waiting for I/O to complete. 
During this time, in the "one thread per request" model, the resources linked to the thread (such as memory) 
are unused and memory is the limiting factor. 
```

```
In the event loop model, the loop thread selects 
the next event (I/O finished) to handle. So the thread is always busy (if you program it correctly of course).
```


```
The event loop model as all new things seems shiny and the solution for all issues but which model to use will 
depend on the scenario you need to tackle. If you have an intensive I/O scenario (like a proxy), 
the event base model will rule, whereas a CPU intensive scenario with a low number of concurrent processes 
will work best with the thread-based model.
```

```
In the real world most of the scenarios will be a bit in the middle. You will need to balance the real need for 
scalability with the development complexity to find the correct architecture (e.g. have an event base front-end that 
delegates to the backend for the CPU intensive tasks. The front end will use little resources waiting for the task result.) 
As with any distributed system it requires some effort to make it work.

If you are looking for the silver bullet that will fit with any scenario without any effort, you will end up with a
bullet in your foot.
```

[In Java, threading is supported at the language level with the synchronized and volatile keywords.](http://stackoverflow.com/a/3306752/432903)

Parallelism
------------

https://github.com/prayagupd/parallel-programming

Data Partitioning
- partitions are units of parallelism

[How does Kafka streaming handle concurrency? Is everything run in a single thread?](https://stackoverflow.com/a/39992430/432903)

[Kafka Streaming data partition](http://docs.confluent.io/current/streams/architecture.html#stream-partitions-and-tasks)

