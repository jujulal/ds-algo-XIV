package arrays

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by prayagupd
  * on 7/31/17.
  */

class LongestSubstringSpecs extends FunSuite with Matchers {

  test("all characters") {
    //
    new LongestSubstring().solution("aaaaaB") shouldBe 6

    //first find the character only substring
    //then check if it has Uppercase
    new LongestSubstring().solution("a0Ba") shouldBe 2

    //
    new LongestSubstring().solution("AAAAAAAa") shouldBe 8

    //invalid
    new LongestSubstring().solution("aaba1aaba") shouldBe -1

    //all numbers
    new LongestSubstring().solution("1111111") shouldBe -1
  }

  test("edge cases") {
    new LongestSubstring().solution("") shouldBe -1
    new LongestSubstring().solution(null) shouldBe -1
    //no special chars
    new LongestSubstring().solution("A-A") shouldBe -1

    //[1..200]
    val password = Range.inclusive(1, 400).map(x => "A").mkString("")
    new LongestSubstring().solution(password) shouldBe -1
  }

}
