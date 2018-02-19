package stack

import org.scalatest.{FunSuite, Matchers}

class ReverseWordsInStringSpec extends FunSuite with Matchers {

  test("reverse") {
    ReverseWordsInString.reverse("hello") shouldBe "hello"
    ReverseWordsInString.reverse("My name is Microsoft") shouldBe "Microsoft is name My"
  }
}
