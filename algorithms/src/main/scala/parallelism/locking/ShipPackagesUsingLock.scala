package parallelism.locking

import java.util.concurrent.locks.ReentrantLock

import parallelism.Database

/**
 * Created by prayagupd
 * on 5/21/16.
 */

class ShipPackagesUsingLock {

  val listLock = new ReentrantLock()
  val stackLock = new ReentrantLock()

  var packageList = Database.packagesList
  val releaseStack = new scala.collection.mutable.Stack[Map[String, String]]()

  def pushToStackAsync(): Unit = {

    val removeLastPackageAndPushToStack = new Runnable {
      override def run(): Unit = {

        listLock.lock()
        val value = packageList.remove(packageList.length - 1)
        stackLock.lock()
        releaseStack.push(value)
        println(s"removePackageAndPushToStack $packageList")
        println(s"removePackageAndPushToStack $releaseStack")
        stackLock.unlock()
        listLock.unlock()
      }
    }

    new Thread(removeLastPackageAndPushToStack).start()
  }

  def popFromStackAsync(): Unit = {
    val popFromStackAndAddToList = new Runnable {
      override def run(): Unit = {
        stackLock.lock()
        val value = releaseStack.pop()
        listLock.lock()
        packageList.+=(value)
        println(s"popFromStackAndAddToList $packageList")
        println(s"popFromStackAndAddToList $releaseStack")
        listLock.unlock()
        stackLock.unlock()
      }
    }

    new Thread(popFromStackAndAddToList).start()
  }
}
