package search

import org.scalatest.FunSuite

class DifferencePairSpecs extends FunSuite {

  test("pair of differences") {
    assert(DifferencePair.diffPairsUsingSeq(Seq(), 2) == 0)
    assert(DifferencePair.diffPairsUsingSeq(Seq(1), 2) == 0)
    assert(DifferencePair.diffPairsUsingSeq(Seq(1, 5, 3, 4, 2), 2) == 3)
  }

  test("pair of differences - array") {
    assert(DifferencePair.diffPairs(Array[Int](), 2) == 0)
    assert(DifferencePair.diffPairs(Array(1, 5), 2) == 0)
    assert(DifferencePair.diffPairs(Array(1, 5, 3, 4, 2), 2) == 3)
  }
}
