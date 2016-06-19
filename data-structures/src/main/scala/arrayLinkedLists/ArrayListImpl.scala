package arraysLinkedLists

import scala.collection.mutable

/**
 * create a class called ArrayList that will be a "growable" array for Strings. You will implement this class by having
    a private array "array" of Strings in the background, but a user of your class will not know about your implementation. 

 * A user will know only that you will provide the ability to add and search for Strings.
 * As the user interacts with an instance of your class, it can happen that, as a result of repeated “adds,” the underlying array "array"
    becomes full.

 * When an “add” is requested and strArray has no free slots, your code must call a private resize method that will create a new background array    that is twice as long; will copy the elements of the old strArray into the first part of the new array; and finally will rename the new array     with the old name strArray.
 *
 **/

class ArrayListImpl(var size: Int,
                val INIT_ARR_SIZE: Int = 2,
                var array: mutable.ArrayBuffer[String]) {

  def this() {
    this(0, 2, new mutable.ArrayBuffer[String](2))
  }

  def add(element: String) {
    //var arr = Array[String]()
    //arr:+="Prayag"
    //println(s"${arr(0)}")

    if (size > array.length) {
      resize()
    }
    println(s"adding element $element.")
    array :+= element
    size = size + 1
  }

  def get(index: Int): String = {
    println(s"getting element for index $index")
    if (index > array.length)
      return "N/A"
    else
      return array(index)
  }

  def search(element: String): Boolean = {
    array.zipWithIndex.foreach { case(arrayElement, index) =>
      if (arrayElement == element) {
        return true
      }
    }
    return false
  }

  def resize() {
    val newSize = 2 * array.length
    var newArray = new mutable.ArrayBuffer[String](newSize)
    array.foreach { element =>
      newArray :+= element
    }
    array = newArray
  }
}
