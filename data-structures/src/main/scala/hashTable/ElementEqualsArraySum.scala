package hashTable

import scala.util.control._

/**
 *
 * an array to be sum-safe if none of its elements is equal to the "sum of all of its elements".

 * The array a = {8, -8, 0} is not sum-safe because the sum of its elements is 0 and a[2] == 0.
 *
 * However, the array a = {8, -10, 6} is sum-safe because the sum of its elements is 4 and none of its elements equal 4.
 */

object ElementEqualsArraySum {

  private def sum(array: Array[Int]): Int = {
    var sum: Int = 0

    array.foreach { item =>
      sum = sum + item
    }

    sum
  }

  def hasAnElementEqualToSumOfArray(array: Array[Int]): Boolean = {
    val arraySum = sum(array)

    val loop = new Breaks
    var elemFound = false

    loop.breakable {
      array.foreach { elem =>
        if (arraySum == elem) {
          elemFound = true
          loop.break
        }
      }
    }

    elemFound
  }
}
