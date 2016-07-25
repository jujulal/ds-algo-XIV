package parallelism.scheduler

import scala.collection.mutable.ListBuffer

/**
 * Created by prayagupd
 * on 7/17/16.
 */

object Stream {
  val STREAM_SIZE = 5
  val stream: ListBuffer[String] = new ListBuffer[String]()

  @throws(classOf[InterruptedException])
  def produce() : Unit = {
    while (stream.size == STREAM_SIZE) {
      wait()
    }
    stream.+(new java.util.Date().toString)
    println("produce message")
    notify()
    //Later, when the necessary event happens, the thread that is running
    // it calls notify() from a block synchronized on the same object.
  }

  // Called by Consumer
  @throws(classOf[InterruptedException])
  def consume : String = {
    notify()
    while (stream.isEmpty) {
      wait() //By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
    }
    def message = stream.head
    stream.-(message)
    message
  }
}
