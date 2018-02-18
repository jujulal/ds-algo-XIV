package compression

/**
  * Difficulty: easy
  * https://www.hackerrank.com/challenges/reduced-string/problem
  * https://www.careercup.com/question?id=7449675
  *
  * I: aaabccddd
  * O: abd
  *
  * related: https://leetcode.com/problems/string-compression/description/
  * I: ["a","a","b","b","c","c","c"]
  * O: ["a","2","b","2","c","3"]
  */

object ReduceString {

  /**
    * this function takes O(n) space for new string
    */
  def compress(uncompressed: String): String = {

    def comp(data: String, index: Int): String =
      if (index == data.length - 1) data
      else if (data(index) == data(index + 1) && data.length == 2 ) ""
      else if (data(index) == data(index + 1)) comp(data.substring(0, index) + data.substring(index + 2), 0)
      else comp(data, index + 1)

    comp(uncompressed, 0)
  }

}
