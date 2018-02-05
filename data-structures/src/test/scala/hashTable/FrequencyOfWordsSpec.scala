package hashTable

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 5/25/16.
 */

class FrequencyOfWordsSpec extends FunSuite {

  test("should return number of occurence") {

    //given:
    val wordToFind = "Steven"
    val book = Array("Steven", "HandCannotErase", "Steven", "steven", wordToFind)

    val freq = FrequencyOfWords.getFrequency(book, wordToFind)

    //then:
    assert(freq == 4)
  }
}
