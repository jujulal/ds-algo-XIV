package stack

import scala.collection.mutable.ArrayBuffer

/**
 * Created by prayagupd
 * on 5/22/16.
 */

class StackWithArrayImpl {

  // There are actually 4 different classes you could choose from to get mutable Array-like functionality.
  //  Array[]+ ArrayOps[] = Java int[] x;
  //  WrappedArray[]      = wrapped java array
  //  ArraySeq[]          = ArraySeq stores its data in a plain old Java array, but it no longer stores arrays of primitives; everything is an array of objects.
  //  ArrayBuffer[]()     = acts like an array, but you can add and remove elements from it.
  // http://stackoverflow.com/a/5029236/432903

  var array = new ArrayBuffer[String]()

  def push(element: String): Unit = {
    array.+=(element)
  }

  def pop(): String = {
    array.remove(array.length - 1)
  }

  def clear(): Unit = {
    for (index <- array.length - 1 to 0 by -1) {
      array.remove(index)
    }
  }
}
