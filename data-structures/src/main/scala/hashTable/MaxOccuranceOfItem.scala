package hashTable

/**
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 * https://www.careercup.com/question?id=13870747
 * Amazon
 * Created by prayagupd
 * on 7/10/16.
 */

object MaxOccuranceOfItem {

  def maxRepeatingWithStupidAlgo(demandedItems: Array[Int]): Int = {
    val itemsSize = demandedItems.length

    // increment array[array[i]%k] by k
    for (index <- 0 until itemsSize) {
      demandedItems(demandedItems(index) % itemsSize) += itemsSize
    }

    // Find index of the maximum repeating element
    var indexOfMaxOccuring = 0
    var maxOccuringItem = demandedItems(indexOfMaxOccuring)

    for (index <- 1 until itemsSize) {
      if (demandedItems(index) > maxOccuringItem) {
        maxOccuringItem = demandedItems(index)
        indexOfMaxOccuring = index
      }
    }

    indexOfMaxOccuring
  }

  def maxRepeatingItem(demandedItems: Array[Int]): Int = {
    //use hashmap for (item -> count) - O(n) space
    // map is like a bucket in this case
    // iterate through map to get the max value
    0
  }
}
