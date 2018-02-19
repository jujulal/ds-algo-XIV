package hashTable

import org.scalatest.FunSuite

import scala.util.control.Breaks

/**
 * Created by prayagupd
 * on 5/31/16.
 */

class ElementEqualsArraySumSpec extends FunSuite {

  test("should sam safe") {

    //given:
    val array = Array(1, 2, 3, -3)

    //then:
    assert(ElementEqualsArraySum.hasAnElementEqualToSumOfArray(array))
  }

}
