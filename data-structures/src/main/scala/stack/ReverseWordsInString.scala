package stack

import scala.collection.mutable

/**
  * Easy (15 mins)
  *
  * Given an input string, reverse the string word by word.
  *
  * https://leetcode.com/problems/reverse-words-in-a-string/description/
  *
  * https://www.glassdoor.com/Interview/Microsoft-Interview-RVW17855542.htm
  *
  * NOTE: Try to solve it in-place in O(1) space
  */

object ReverseWordsInString {

  def reverse(sentence: String): String = {

    var word = ""
    val stackOfWords = new mutable.Stack[String]()

    //time: O(length)+ n * O(1)
    for (index <- 0 until sentence.length) {
      val char = sentence(index)

      if (char == ' ') {
        stackOfWords.push(word)
        word = ""
      } else if (index == sentence.length - 1) {
        word = word + char
        stackOfWords.push(word)
        word = ""
      } else {
        word = word + char
      }
    }

    //time: n * O(1)
    //space: O(n)
    var reversedSentences = ""
    var stackIndex = 0

    while (stackOfWords.nonEmpty) {
      if (stackIndex == 0) reversedSentences = stackOfWords.pop()
      else reversedSentences = reversedSentences + " " + stackOfWords.pop()
      stackIndex = stackIndex + 1
    }

    reversedSentences
  }
}
