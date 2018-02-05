package search

import org.scalatest.FunSuite

class CheckStringSubsequenceSpecs extends FunSuite {

  test("checks existing substring") {

    assert(CheckStringSubsequence.isSubString("oereiamstderreceived", "orderreceived") == "YES")

  }

  test("checks not-existing substring") {

    assert(CheckStringSubsequence.isSubString("orderdelivered", "orderreceived") == "NO")

  }
}
