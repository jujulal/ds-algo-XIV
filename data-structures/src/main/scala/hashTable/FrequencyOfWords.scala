package hashTable

import scala.collection.mutable

/**
  *
  * 19.8 Design a method to find the frequency of occurrences of any given word in a book.
  *
  * Solution: Repetitive Queries
  */

object FrequencyOfWords {

  private def buildFrequencyTable(book: Array[String]): mutable.HashMap[String, Integer] = {

    val hashTable = mutable.HashMap.empty[String, Integer] //Space complexity < n (length of dictionary array)

    //Time complexity (n)
    book.foreach { word =>

      if (word.toLowerCase.trim() != "") {
        if (!hashTable.contains(word.toLowerCase)) hashTable(word.toLowerCase) = 0
        hashTable += word.toLowerCase -> (hashTable(word.toLowerCase) + 1)
      }

    }

    hashTable

  }

  def getFrequency(book: Array[String], word: String): Int = {
    val freq = buildFrequencyTable(book)

    if (freq.contains(word.toLowerCase)) freq(word.toLowerCase)
    else 0
  }

}
