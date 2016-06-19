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

  def sort(array: Array[Int]) : Array[Int] = {

    println("original array : ")
    array.foreach { case x : Int =>
      println(s" $x")
    }

    constructHeap(array)

    // Now do Selection sort by retrieving max/min element and swapping with elements at top/END

    var endOfArray = array.length - 1

    while (endOfArray > 0) {
      // swap first elem with last
      val temp = array(0)
      array(0) = array(endOfArray)
      array(endOfArray) = temp
      bubbleDown(array, 0, endOfArray - 1)
      endOfArray = endOfArray - 1
    }

    println("sorted array : ")
    for (i <- 0 until array.length) {
      println(array(i))
    }
    
    array
  }

  def constructHeap(array : Array[Int]) {
    val endOfArray = array.length - 1
    val middle = (array.length/2)-1

    breakable {
      for (startIndexThatsLessThanMiddle <- middle to 0 by -1) {
        bubbleDown(array, startIndexThatsLessThanMiddle, endOfArray)
        if (startIndexThatsLessThanMiddle == 0)
          break()
      }
    }

    println("heap constructed : ")
    array.foreach {case x => println(s" $x ")}
  }

  def bubbleDown(array: Array[Int], start: Int, end: Int){
    var root = start

    while (root * 2 + 1 <= end) { // at least one child exists
      var swap = root
      val child = root * 2 + 1
      val rchild = root * 2 + 2
      if(array(swap) < array(child)){
        swap = child
      }
      if(rchild<=end && array(swap)<array(rchild)){
        swap = rchild
      }
      if(swap!=root){
        // swap here
        val temp = array(root)
        array(root) = array(swap)
        array(swap) = temp
        root = swap
      }else
        return
    }
  }
}

