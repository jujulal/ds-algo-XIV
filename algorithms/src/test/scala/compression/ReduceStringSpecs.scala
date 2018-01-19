package compression

import org.scalatest.FunSuite

class ReduceStringSpecs extends FunSuite {

  //aaabccddd -> abccddd
  //aaabccddd -> abcddd
  //aaabccddd -> abcd
  test("comress") {
    assert(ReduceString.compress("aa") == "")
    assert(ReduceString.compress("baab") == "")
    assert(ReduceString.compress("abccddd") == "abd")
    assert(ReduceString.compress("aaabccddd") == "abd")
  }
}
