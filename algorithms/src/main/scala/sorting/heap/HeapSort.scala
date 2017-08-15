package sorting.heap

import scala.util._
import scala.collection.mutable._
import scala.util.Random
import util.control.Breaks.breakable
import util.control.Breaks.break

/**
  * @author : prayagupd
  * http://qerub.se/purely-functional-heap-sort-in-scala
  * http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
  */

object HeapSort {

  def sortAsc(array: Array[Int]): Array[Int] = {

    constructMaxHeap(array)

    // Now do Selection sort by retrieving max/min element and swapping with elements at top/END
    //so that largest element is at the bottom
    var largerIndex = array.length - 1

    while (largerIndex > 0) {
      // swap first elem with last
      val swapHelper = array(0)
      array(0) = array(largerIndex)
      array(largerIndex) = swapHelper
      bubbleElementDown(array, 0, largerIndex - 1)
      largerIndex = largerIndex - 1
    }

    array
  }

  /**
    *
    */
  def constructMaxHeap(array: Array[Int]): Array[Int] = {
    val endOfArray = array.length - 1
    val middle = (array.length / 2) - 1

    breakable {

      for (startIndex_ThatsLessThanMiddle <- middle to 0 by -1) {

        bubbleElementDown(array, startIndex_ThatsLessThanMiddle, endOfArray)

        if (startIndex_ThatsLessThanMiddle == 0) break()
      }

    }

    println("heap constructed : ")
    array.foreach { case x => print(s" $x ,") }

    array
  }

  def bubbleElementDown(array: Array[Int], start: Int, end: Int) {
    var rootIndex = start

    // iterate until there exists at least one child for a root
    // eg. In [x, y, z], x has child y and z

    while (rootIndex * 2 + 1 <= end) {
      var largestNodeIndex = rootIndex
      val leftChild = (rootIndex * 2) + 1
      val rightChild = (rootIndex * 2) + 2

      //if leftChild is greater than root, exchange
      if (array(largestNodeIndex) < array(leftChild)) {
        largestNodeIndex = leftChild
      }

      //if theres right child which is greater than root
      if (rightChild <= end && array(largestNodeIndex) < array(rightChild)) {
        largestNodeIndex = rightChild
      }

      //if largest node and original root are same => no ops
      //else swap values around
      if (largestNodeIndex != rootIndex) {
        // swap here
        val swapHelper = array(rootIndex)
        array(rootIndex) = array(largestNodeIndex)
        array(largestNodeIndex) = swapHelper
        rootIndex = largestNodeIndex
      } else
        return
    }
  }
}
