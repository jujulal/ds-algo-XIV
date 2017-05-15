[data types memory sizes](http://cs.fit.edu/~ryan/java/language/java-data.html)
------------------------

| type              | size    |
|-------------------|----------
| boolean           | 1 bit   |
| byte              | 1 byte  |
| char/short-int    | 2 bytes |
| int/float         | 4 byte  |
| long/double       | 8 byte  |

Object Memory allocation
-------------------------

http://prayagupd-dreamspace.blogspot.com/2013/03/java-hotspot-vm-options.html

[Object allocation/ Thread Local Areas](https://goo.gl/DtW1kn)

```
Small objects are allocated in thread local areas (TLAs). The thread local areas are free chunks 
reserved from the heap and given to a Java thread for exclusive use.
```

[Memory allocation on C++ object creation](http://stackoverflow.com/a/9058201/432903)

[Understanding JVM Memory Allocation and Java Out of Memory: Heap Space](http://stackoverflow.com/a/21276727/432903)

```
Java objects reside in an area called the heap(heap = newgen + oldgen heap). 

The heap is created when the JVM starts up and may increase or decrease in size while the 
application runs. 

When the heap becomes full, garbage is collected. 
During the gc, objects that are no longer used are cleared, thus making space for new objects.

Note
---------

JVM uses more memory than just the heap.(PermGen) 

For example _java #methods, thread stacks and native handles_ are allocated in memory
separate from the heap, as well as JVM internal data structures.
```

[What is Stack/ Heap](http://stackoverflow.com/a/80113/432903)
---------------------

![](https://i.stack.imgur.com/i6k0Z.png)

The stack is the memory set aside as scratch space for a thread of execution. 
When a function is called, a block is reserved on the top of the stack for local variables and some 
bookkeeping data. 

[The heap is memory set aside for dynamic allocation.](http://stackoverflow.com/a/79936/432903)

GC
---

```
The garbage collector is a program which runs on the Java Virtual Machine which gets rid of objects 
which are not being used by a Java application anymore. 

It is a form of automatic memory management.
```

```
Garbage Collector is part of JRE that makes sure that object that are not referenced 
will be freed from memory.
```

[STW pauses/ Full GC](http://stackoverflow.com/a/16718346/432903)
--------------------

```
Using the throughput GC, the JVM needs "STW pauses" to be the free as much memory as possible. 
It is only using such pauses that it is the most effective.

Using the "low-pauses collector (CMS)", you clean the old-gen concurrently, without pausing 
your app. 
The drawback with CMS is that the old-gen become fragmented. If it is too fragmented and need 
a compaction(C), a "Full GC (STW)" happens. 

However, you can always tune your application so that you "do not get any Full GC".

G1 GC is a special case. Its current primary goal is to have a low fragmentation on the heap, 
while still being concurrent (like CMS). When it cannot reach this goal, the JVM also reverts to 
a STW pause so that the heap is entirely cleaned and compacted.
```

[What is OS fragmentation](https://goo.gl/lAvdFd)
---------------------------

```
When a computer program requests blocks of memory from the computer system, the blocks are allocated 
in chunks. 
When the computer program is finished with a chunk, it can free the chunk back to the system, 
making it available to later be allocated again to another or the same program. 

The size and the amount of time a chunk is held by a program varies. During its lifespan, a 
computer program can request and free many chunks of memory.

When a program is started, the free memory areas are long and contiguous/in sequence. Over time 
and with use, the long contiguous regions become fragmented into smaller and smaller contiguous areas. 
Eventually, it may become impossible for the program to obtain large contiguous chunks of memory.

```

[How is data stored in Filesystems(ext2, ext3 etc)? Say, I saved file1.log and then file2.log. Later I added info 
to file1.log, how the memory is allocated?](http://unix.stackexchange.com/a/75667/17781)

JVM GC
========

http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html

<img src="http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/images/gcslides/Slide5.png" width="550">

http://www.cubrid.org/blog/dev-platform/understanding-java-garbage-collection/

https://plumbr.eu/handbook/garbage-collection-in-java

http://www.artima.com/insidejvm/ed2/gcP.html


[When is the finalize() method called in Java?](http://stackoverflow.com/a/2506525/432903) (INTV, 06-18-2016)

```
The finalize method is called when an object is about to get garbage collected. 
That can be at any time after it has become eligible for garbage collection.
```


https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html

https://blog.udemy.com/java-static-class/
