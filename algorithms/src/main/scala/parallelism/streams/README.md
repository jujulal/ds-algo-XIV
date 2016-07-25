channels/ message passing
-------------------------

[How threads communicate to each other??](http://stackoverflow.com/a/3852472/432903), INTV 2015

- [shared memory/ in use with lock/semaphores](https://behelmy.wordpress.com/parrallel-computing/shared-memory-vs-message-passing-programming-model/)

```
An advantage of this model from the programmer’s point of view is that the notion of data “ownership” is lacking, 
so there is no need to specify explicitly the communication of data between tasks. 

Program development can often be simplified.
```

```
An important disadvantage in terms of performance is that it becomes more difficult to understand and manage 
data locality. 

Keeping data local to the processor that works on it conserves memory accesses, cache refreshes and bus traffic 
that occurs when multiple processors use the same data.

Unfortunately, controlling data locality is hard to understand and beyond the control of the average user.
```

- channels/ Producer consumer pattern/ Java BlockingQueue

```
A channel is a message queue into which a sender can place messages and from which a receiver can remove messages, 
blocking if messages are not available. 
```

Joe Armstrong, 

```
With shared memory, you communicate by SHARING DATA, with messaging, you share data by COMMUNICATING.
```

[When I should I use message passing over shared memory?](http://programmers.stackexchange.com/a/116887/31060)

```
The message passing model is considerably simpler to understand — you just have a stream of messages coming in that you want to process — 
and it maps much more nicely to what is actually possible with networks so it obviously can scale up massively.
```

[Java 7 newIO Buffer and Channels](https://docs.oracle.com/javase/7/docs/api/java/nio/channels/package-summary.html)

```
channel represents connections to entities that are capable of performing I/O operations, 
such as files and sockets; 

selector for multiplexed, non-blocking I/O operations.
```

```
    val data = new RandomAccessFile("warehouse/shipping-items", "rw")
    val inChannel : FileChannel = data.getChannel() 

    val buffer = ByteBuffer.allocate(48)

    int bytesRead = inChannel.read(buffer) //always reads from buffer
    while (bytesRead != -1) {

      println("Read " + bytesRead)
      buf.flip() // switches a Buffer from writing mode to reading mode. 
                 // sets the position back to 0, 

      while(buffer.hasRemaining()){
          print((char) buffer.get())
      }

      buf.clear()
      bytesRead = inChannel.read(buffer)
    }
    data.close()
```

![](http://tutorials.jenkov.com/images/java-nio/buffers-modes.png)

https://golang.org/doc/effective_go.html#channels

https://golang.org/pkg/sync/

http://docs.julialang.org/en/latest/manual/parallel-computing/#channels

http://www.scala-lang.org/docu/files/actors-api/actors_api_guide_4.html

https://en.wikipedia.org/wiki/Communicating_sequential_processes

http://clojure.com/blog/2013/06/28/clojure-core-async-channels.html