package arrays

import org.scalatest.{FunSuite, Matchers}

class ContiniousSumCheckSpec extends FunSuite with Matchers {

  test("check sum") {

    ContiniousSumCheck.continiousSumCheck(Array(23, 5, 4, 7, 2, 11), 20) shouldBe true

    ContiniousSumCheck.continiousSumCheck(Array(1, 3, 5, 23, 2), 8) shouldBe true

  }
}
