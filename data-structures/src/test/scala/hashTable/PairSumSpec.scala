package hashTable

import hashTable.PairSum
import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 5/26/16
 */

class PairSumSpec extends FunSuite {
  test("crap") {
    val array = Array(1,2,3,-3,0)
    val table = PairSum.pairSum(array)
    table.foreach { case (k, v) =>
      println(s"$k+$v")
    }

    assert(table == Map(1 ->2, 3 -> 0))
  }
}