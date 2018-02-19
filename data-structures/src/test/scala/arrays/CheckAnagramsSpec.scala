package arrays

import org.scalatest.{FunSuite, Matchers}

class CheckAnagramsSpec extends FunSuite with Matchers {

  test("check anagram") {
    CheckAnagrams.isAnagram("Microsoft", "softMicro") shouldBe true
    CheckAnagrams.isAnagram("Facebook", "bookFacce") shouldBe false

  }
}
