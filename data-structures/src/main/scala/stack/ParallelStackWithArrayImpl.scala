package stack

import java.util.concurrent.locks.ReentrantLock

import scala.collection.mutable.ArrayBuffer

/**
 * Created by prayagupd
 * on 5/22/16.
 */

class ParallelStackWithArrayImpl {

  var array = new ArrayBuffer[String]()

  val operationAllowed =  new ReentrantLock()

  def push(element : String): Unit = {
    operationAllowed.lock()
      array.+=(element)
      println(s"added -------------- $element")
    operationAllowed.unlock()
  }

  def pop(): String = {
    if(array.nonEmpty) {
      operationAllowed.lock()
      val value = array.remove(array.length - 1)
      println(s"popped ----------- $value")
      operationAllowed.unlock()
      return value
    }
    ""
  }

  def clear(): Unit = {

    operationAllowed.lock()
    for(index <- array.length-1 to 0 by -1) {
      array.remove(index)
    }
    operationAllowed.unlock()
  }
}
