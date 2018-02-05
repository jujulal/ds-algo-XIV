package hashTable

import hashTable.PairSum
import org.scalatest.FunSuite

/**
  * Created by prayagupd
  * on 5/26/16
  */

class PairSumSpec extends FunSuite {

  test("a+b==3") {
    assert(PairSum.pairSum(Array(1, 2, 3, -3, 0)) == Map(1 -> 2, 3 -> 0))
  }

}
