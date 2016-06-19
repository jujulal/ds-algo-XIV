package hashTable

import scala.collection.mutable

/**
 *
 * 19.11 Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 *
 * One easy and (time) efficient solution involves a hash map from integers to integers.
 */

object PairSum {

  def pairSum(array: Array[Int]): mutable.HashMap[Int, Int] = {
    var arraySum: Int = 0 //space1

    array.foreach { item =>
      arraySum = arraySum + item //time1
    }
    println("sum => " + arraySum)
    val hashTable = mutable.HashMap.empty[Int, Int] //space2
    for (index <- 0 until array.length - 1 by 1) {
      //time2
      for (nextIndex <- index + 1 until array.length by 1) {
        if (arraySum == array(index) + array(nextIndex)) {
          println(s"array($index) + array($nextIndex) = $arraySum")
          hashTable += array(index) -> array(nextIndex)
        }
      }
    }
    hashTable
  }
}
