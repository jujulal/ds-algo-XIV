package parallelism.scheduler

import java.util.Date

import parallelism.Database

import scala.collection.mutable.ArrayBuffer

/**
 * Created by prayagupd
 * on 5/21/16.
 */

class PackagesShippingScheduler {

  var packagesShippedState = new ArrayBuffer[Map[String, Date]]

  def shipPackages(): Unit = {

    def shipPackage = new Runnable {
      override def run(): Unit = {
        Database.packagesState.zipWithIndex.foreach { case(map, i) =>
          val key = map.keys.toList.collectFirst{ case x:String => x }.get
          packagesShippedState += Map(key -> new Date())
          println(s"shipping done for ${packagesShippedState(i).keys}")
        }
      }
    }

    println("shipping starts")
    new Thread(shipPackage).start()

  }
  
}
