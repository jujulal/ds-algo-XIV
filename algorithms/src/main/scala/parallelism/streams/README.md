channels/ message passing
-------------------------

[How threads communicate to each other??](http://stackoverflow.com/a/3852472/432903), INTV 2015

- [shared memory/ in use with lock/semaphores](https://behelmy.wordpress.com/parrallel-computing/shared-memory-vs-message-passing-programming-model/)

```
An advantage of this model from the programmer’s point of view is that the notion of data “ownership” 
is lacking, so there is no need to specify explicitly the communication of data between tasks. 

Program development can often be simplified.
```

```
An important disadvantage in terms of performance is that it becomes more difficult to understand 
and manage data locality. 

Keeping data local to the processor that works on it conserves memory accesses, cache refreshes 
and bus traffic that occurs when multiple processors use the same data.

Unfortunately, controlling data locality is hard to understand and beyond the control of the 
average user.
```

- channels/ sockets(IO)/ Producer consumer pattern/ Java BlockingQueue

```
A channel is a message queue into which a sender can place messages and from which a receiver can i
remove messages, blocking if messages are not available. 
```

Joe Armstrong quotes, 

```
With shared memory, you communicate by SHARING DATA, with messaging, you share data by COMMUNICATING.
```

[When should I use message passing over shared memory?](http://programmers.stackexchange.com/a/116887/31060)

```
The message passing model is considerably simpler to understand — you just have a stream of messages 
coming in that you want to process — 
and it maps much more nicely to what is actually possible with networks so it obviously can scale up massively.
```

[Java 7 newIO Buffer and Channels](https://docs.oracle.com/javase/7/docs/api/java/nio/channels/package-summary.html)

```
channel represents connections to entities that are capable of performing I/O operations, 
such as files and sockets; 

selector for multiplexed, non-blocking I/O operations.
```

[file channel example](http://tutorials.jenkov.com/java-nio/buffers.html)

```scala
    val sourcedata = new RandomAccessFile("warehouse/shipping-items", "rw")
    val inChannel : FileChannel = sourcedata.getChannel() 

    val inbuffer = ByteBuffer.allocate(48) //bytes

    int hasBytes = inChannel.read(inbuffer) //always reads from buffer
    while (hasBytes != -1) {

      println("Read " + hasBytes)
      inbuffer.flip() // switches a Buffer from writing mode to reading mode. 
                      // sets the position back to 0, 

      while(inbuffer.hasRemaining()){
          print((char) inbuffer.get())
      }

      inbuffer.clear()
      hasBytes = inChannel.read(inbuffer)
    }
    sourcedata.close()
```

[Message Delivery Reliability](http://doc.akka.io/docs/akka/current/scala/general/message-delivery-reliability.html)

```
semantics of a delivery mechanism, there are three basic categories:

- at-most-once delivery (0..1) - cheapest, fire & forget, stateless sender, stateless transport
- exactly-once delivery (1) - most expensive, stateful sender, transport, receiver processed state
- at-least-once delivery (1..*) - expensive, stateful sender, transport, receiver
```

[10.9  If I send a message, is it guaranteed to reach the (erlang) receiver?](http://erlang.org/faq/academic.html)

```
It seems this issue of "guaranteed delivery" comes up every now and then, 
but I've never managed to find out exactly what it is those that are asking for it actually want:

1) A guarantee that the message is put into the receiver's input queue/mailbox/stream/channel? 
But if the receiver dies before extracting it from there, that guarantee is useless, as the message 
is lost anyway.

2) A guarantee that the receiver extracts the message from its input queue/mailbox?
Well, besides the obvious problem that depending on how the receiver is written,
even if it lives happily ever after it may never extract that particular message,
it suffers from a variant of the previous problem: Even if you "know" that the receiver has "consumed"
the message, it may die before acting on it in any way, and then again it may as well never have been sent.

3) A guarantee that the receiver actually processes the message? 
Just kidding of course, hopefully it's obvious to everyone that the only way to obtain such a guarantee, 
regardless of what communication system(or programming) you use, is that the receiver is programmed to send 
an explicit acknowledgment when the processing is complete (of course this may be hidden below an 
abstraction such as RPC, but the fundamental principle holds).
```

[Nobody needs reliable messaging in SOA/ Webservice](https://www.infoq.com/articles/no-reliable-messaging)

```
Reliable messaging is the guarantee that a message sent by a sending application is indeed 
received at the other end, and received only once.
```

![](https://cdn.infoq.com/statics_s1_20170523-0350/resource/articles/no-reliable-messaging/en/resources/Biz-Transport-Level.png)

[actor message delivery guarantees for local/remote transports](https://groups.google.com/forum/#!topic/akka-user/Ih9HqTbI9NM)

![](http://tutorials.jenkov.com/images/java-nio/buffers-modes.png)

[The actor model: Why is erlang special? Or, why do you need another language for it?](https://stackoverflow.com/q/8107612/432903)

https://golang.org/doc/effective_go.html#channels

https://golang.org/pkg/sync/

http://docs.julialang.org/en/latest/manual/parallel-computing/#channels

http://www.scala-lang.org/docu/files/actors-api/actors_api_guide_4.html

https://en.wikipedia.org/wiki/Communicating_sequential_processes

http://clojure.com/blog/2013/06/28/clojure-core-async-channels.html
