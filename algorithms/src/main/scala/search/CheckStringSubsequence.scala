package search

/**
  * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
  *
  *
  * Similar;
  * Given a string, find the length of the longest substring without repeating characters.
  * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
  * Given "abcabcbb", the answer is "abc", which the length is 3.
  */

object CheckStringSubsequence {

  def isSubString(data: String, term: String): String = {

    var keepSearching = true
    var wholeWord = true
    var dataInd = 0

    for (termIndex <- 0 until term.length if keepSearching) {
      val termChar = term(termIndex)

      var charFound = false

      for (dataIndex <- dataInd until data.length if !charFound) {
        if (data(dataIndex) == termChar) {
          charFound = true
          dataInd = dataIndex + 1
        } else if (dataIndex == data.length - 1) {
          charFound = false
          keepSearching = false
        }
      }

      wholeWord = wholeWord && charFound
    }

    if (wholeWord) "YES"
    else "NO"
  }

}
