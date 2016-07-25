package hashTable

/**
 * Given a non-empty array of integers, return the k most frequent elements.
  For example,
  Given [1,1,1,2,2,3] and k = 2, return [1,2].

  Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * https://leetcode.com/problems/top-k-frequent-elements/
 * Created by prayagupd
 * on 7/14/16.
 */

object TopKFrequentElements {

  // http://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/

  //1 - simply sort hashMap on each insertion by value - complexity might be very high

  //2 - count on hashmap
  // use max heap -> PriorityQueue in java -> O(n*log(k))
  def frequentElements(array: Array[Int], count: Int): Int = {
    0
  }
}
