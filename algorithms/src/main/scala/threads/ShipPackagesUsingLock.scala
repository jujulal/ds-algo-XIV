package threads

import java.util.concurrent.locks.{ReentrantLock, Lock}

/**
 * Created by prayagupd
 * on 5/21/16.
 */

class ShipPackagesUsingLock {

  val listLock = new ReentrantLock()
  val stackLock = new ReentrantLock()

  var list = Database.packagesList
  val stack = new scala.collection.mutable.Stack[Map[String, String]]()

  def pushToStackAsync(): Unit = {

    val removePackageAndPushToStack = new Runnable {
      override def run(): Unit = {

        listLock.lock()
        val value = list.remove(list.length - 1)
        stackLock.lock()
        stack.push(value)
        println(s"removePackageAndPushToStack $list")
        println(s"removePackageAndPushToStack $stack")
        stackLock.unlock()
        listLock.unlock()
      }
    }

    new Thread(removePackageAndPushToStack).start()
  }

  def popFromStackAsync(): Unit = {
    val popFromStackAndAddToList = new Runnable {
      override def run(): Unit = {
        stackLock.lock()
        val value = stack.pop()
        listLock.lock()
        list.+=(value)
        println(s"popFromStackAndAddToList $list")
        println(s"popFromStackAndAddToList $stack")
        listLock.unlock()
        stackLock.unlock()
      }
    }

    new Thread(popFromStackAndAddToList).start()
  }
}
