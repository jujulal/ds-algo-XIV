package arrays
/**
 * 1.4 Write a method to decide if two strings are anagrams or not.
 * <p>
 * write Junit for cases
 * <p>
 * NVIDIA
 * http://www.careercup.com/question?id=8641795
 * <p>
 * Time Complexity – O(n) (time to go through the arrays at once)
 * Space Complexity – O(1) (Only a finite array needed depending on how many different chars we may have)
 * http://www.fitcoding.com/2014/02/10/two-strings-are-anagrams-java/
 * <p>
 * http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 * <p>
 * NOTE: if done by sorting both strings and comparing each char
 * Sorting an array, Arrays.sort(string1Array);  =>  Time – O(n*log(n))
 * <p>
 * Google
 * Given two strings a and b, find whether any anagram of string a is a sub-string of string b. For eg:
 * if a = xyz and b = afdgzyxksldfm then the program should return true.
 * http://www.careercup.com/question?id=5389078581215232
 * 03-26-2015, Iowa
 */

object Anagrams {

  /**
   * time : O(n) + O(n)
   */
  def areAnagrams (string1: String, string2: String): Boolean = {

    if (string1 == null || string2 == null) return false
    if (string1.length != string2.length) return false

    val string1Array: Array[Char] = string1.toCharArray
    val string2Array: Array[Char] = string2.toCharArray

    val letterCounts: Array[Int] = new Array[Int](256)

    // calculate counts, same as two separate operations above - O(n)
    for (index <- 0 until string1Array.length) {
      letterCounts(string1Array(index)) = letterCounts(string1Array(index)) + 1
      letterCounts(string2Array(index)) = letterCounts(string2Array(index)) - 1
    }

    //check if everything is balanced - O(n)
    letterCounts.indices.foreach { case index =>
      if (letterCounts(index) != 0) {
          return false
      }
    }
    true
  }
}