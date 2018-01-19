package search

import org.scalatest.FunSuite

class PairSpecs extends FunSuite {

  test("pair of differences") {
    assert(Pair.diffPairs(Seq(), 2) == 0)
    assert(Pair.diffPairs(Seq(1), 2) == 0)
    assert(Pair.diffPairs(Seq(1, 5, 3, 4, 2), 2) == 3)
  }

  test("pair of differences - array") {
    assert(Pair.diffPairs(Array[Int](), 2) == 0)
    assert(Pair.diffPairs(Array(1, 5), 2) == 0)
    assert(Pair.diffPairs(Array(1, 5, 3, 4, 2), 2) == 3)
  }
}
