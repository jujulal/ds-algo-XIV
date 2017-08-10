package arrays

import scala.util.control._

/**
  * 1.3
  * Design an algorithm and write code to remove the duplicate characters in a string
  * without using any additional buffer. 
  *
  * NOTE: One or two additional variables are fine.
  * An extra copy of the array is not.
  *
  * FOLLOW UP
  * Write the test cases for this method.
  * usage : scala UniqueCharacters.scala prayag
  */

import scala.util.control.Breaks._


object RemoveDuplicatesFromString {

  def removeDuplicate2(word: String): String = {
    var newWord = ""

    breakable {
      for (leader <- 1 until word.length) {

        for (follower <- 0 until leader) {
          if (word(follower).equals(word(leader))) {
            newWord = word.substring(0, leader) + word.substring(leader + 1, word.length)

            println(s"dedup ${word}  => new word ${newWord}")
            removeDuplicate2(newWord)
            println(s"new word :: ${newWord}")
            break()
          }
        }
      }
    }
    newWord
  }

  def removeDuplicate(word: String): String = {
    val len: Int = word.length()
    //if ( len < 2 ) {
    //	return ""
    //}

    val wordArray = word.toArray
    var tailer = 1

    for (header <- 1 until word.length() by 1) {
      val loop = new Breaks
      var previousIndex = 0

      loop.breakable {
        //for (previousIndex <- 0 until tailIndex)
        while (previousIndex < tailer) {
          println(s"compareIndex $previousIndex == compareToIndex $header")
          if (wordArray(previousIndex) == wordArray(header)) {
            loop.break
          }
          previousIndex += 1
        } //end of duplicate char compare
      }
      println(s"for compareToIndex $header => compare compareIndex $previousIndex== tailIndex $tailer")
      if (previousIndex == tailer) {
        wordArray(tailer) = wordArray(header)
        tailer += 1
      }
      println("=========================")
    } //end of compareToIndex

    wordArray(tailer) = 0
    return new String(wordArray)

  }
}
