package parallelism.barrier

import java.util.concurrent.{BrokenBarrierException, CyclicBarrier}

/**
 * Created by prayagupd
 * on 6/22/16.
 */

class PackageItemsBarrier {
  var readyToPack = false

  val NO_OF_ITEMS = 3
  val packageBarrierWaitingForAllItems = new CyclicBarrier(NO_OF_ITEMS)

  def initiatePacking() {
    for (index <- 0 until NO_OF_ITEMS) {
      val th = new Thread(new ItemConveyor(index), "Item-" + index)
      th.start()

      conveyTakesTime()
    }
  }

  private def conveyTakesTime(): Unit = {
    Thread.sleep(1000)
  }

  private class ItemConveyor(name: Int) extends Runnable {

    override def run() {
      println(s"Conveyor ships $name to destination packing lane.")
      packageBarrierWaitingForAllItems.await()
      println(s"package $name arrived at packing lane.")
      readyToPack = true
    }
  }
}