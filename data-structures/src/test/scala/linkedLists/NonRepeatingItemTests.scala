package linkedLists

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 7/10/16.
 */

class NonRepeatingItemTests extends FunSuite {

  test("gives the first non repeating character") {
    val array = "wdreamream"

    val processor = new NonRepeatingItem()

    array.foreach(char => {
      val actual: Char = processor.getFirstNonRepeating(char)

      val expected : Char = 'w'

      assert(actual == expected)
    })
  }
}
