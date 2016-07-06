[JVM Thread Scheduling](http://lass.cs.umass.edu/~shenoy/courses/fall01/labs/talab2.html)

```
- The JVM schedules using a pre-emptive MT, priority based scheduling algorithm.

   JVM would simply use the underlying threading mechanism provided by the OS, which would imply POSIX Threads (pthreads) on UNIX (Mac OS X, Linux, etc.) 
   and would imply WIN32 threads on Windows. Typically, those systems use a round-robin strategy by default.
   
- All Java threads have a priority and the thread with he highest priority is scheduled to run by the JVM.
  -- In case two threads have the same priority a FIFO ordering is followed.
```

[Starvation and Fairness](http://tutorials.jenkov.com/java-concurrency/starvation-and-fairness.html)

```
If a thread is not granted CPU time because other threads grab it all, it is called "starvation". 
The thread is "starved to death" because other threads are allowed the CPU time instead of it. 

Solution to starvation is called "fairness" - that all threads are fairly granted a chance to execute.
```


[Ticket lock](https://en.wikipedia.org/wiki/Ticket_lock)

```
the method that many bakeries and delis use to serve customers in the order that they arrive, without making them stand in a line. 
```

[Spinlock](https://en.wikipedia.org/wiki/Spinlock)

```
a lock which causes a thread trying to acquire it to simply wait in a loop ("spin") while repeatedly checking if the lock is available. 
Since the thread remains active but is not performing a useful task, the use of such a lock is a kind of busy waiting. 
```