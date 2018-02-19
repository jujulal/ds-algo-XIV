package arrays

/**
  * Medium: https://leetcode.com/problems/continuous-subarray-sum/description/
  *
  * Given a sequence of positive integers A (patient visits in a month) and an integer T (total continious visits),
  * return whether there is a continuous sequence of A that sums up to exactly T
  * Example
  * [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20
  * [1, 3, 5, 23, 2], 8.      Return True because 3 + 5 = 8
  * [1, 3, 5, 23, 2], 7       Return False because no sequence in this array adds up to 7
  * <p>
  * Complexity - O(n2)
  */

object ContiniousSumCheck {

  def continiousSumCheck(sequence: Array[Int], checkWith: Int): Boolean = {

    def findSum(currentIndex: Int, nextIndex: Int, sum: Int, sequence: Array[Int], k: Int): Boolean = {

      val newSum = sum + sequence(currentIndex)

      if(newSum > k && currentIndex == sequence.length - 1)
        false
      else if (newSum > k)
        findSum(currentIndex + 1, currentIndex + 1, 0, sequence, k)
      else if (newSum < k)
        findSum(currentIndex, nextIndex + 1, newSum, sequence, k)
      else
        true
    }

    findSum(0, 0, 0, sequence, checkWith)
  }

}
