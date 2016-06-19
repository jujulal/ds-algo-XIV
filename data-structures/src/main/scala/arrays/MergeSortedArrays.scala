package arrays

import scala.collection.mutable.ArrayBuffer

/**
 * Created by prayagupd
 * on 6/5/16.
 */

object MergeSortedArrays {

  /**
   *
   * http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
   */
  def merge(first: Array[Int], second: Array[Int]): Array[Int] = {
    var len1 = first.length
    var len2 = second.length

    val newArray = Array.ofDim[Int](len1 + len2)
    var index = 0
    while(index < first.length) {
      newArray(index) = first(index)
      index = index + 1
    }

    while (len1 > 0 && len2 > 0) {
      if (first(len1 - 1) > second(len2 - 1)) {
        newArray(len1 + len2 - 1) = first(len1 - 1)
        len1 = len1 - 1
      } else {
        newArray(len1 + len2 - 1) = second(len2 - 1)
        len2 = len2 - 1
      }
    }

    while (len2 > 0) {
      newArray(len1 + len2 - 1) = second(len2 - 1)
      len2 = len2 - 1
    }

    newArray
  }
}
