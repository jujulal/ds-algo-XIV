package parallelism.scheduler

/**
  * Created by prayagupd
  * on 7/17/16.
  */

class Consumer extends Thread {

  override def run() {
    try {
      while (true) {
        val message = Stream.consume
        println("Got message: " + message)
        //sleep(200)
      }
    } catch {
      case ex: InterruptedException =>
        ex.printStackTrace()
    }
  }

}

object Main {

  def main(args: Array[String]) {
    new Producer().start()
    new Consumer().start()
  }

}
