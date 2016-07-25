package parallelism.scheduler

import scala.collection.mutable.ListBuffer

/**
 * Created by prayagupd 
 * on 7/16/16.
 */


class Producer extends Thread {

  override def run() {
    try {
      while (true) {
        Stream.produce()
      }
    } catch {
      case ex : InterruptedException => println(ex)
    }
  }
}
