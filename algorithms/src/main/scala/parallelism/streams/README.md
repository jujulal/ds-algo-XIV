channels
--------

[Java 7 newIO channels](https://docs.oracle.com/javase/7/docs/api/java/nio/channels/package-summary.html)

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