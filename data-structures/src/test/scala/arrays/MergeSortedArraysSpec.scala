package arrays

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/5/16.
 */

class MergeSortedArraysSpec extends FunSuite {

  test("should merge sorted arrays") {
    val first = Array(1, 2, 5, 6, 7)
    val second = Array(3, 4)

    val sorted = MergeSortedArrays.merge(first, second)

    assert(sorted.length == 7)
    assert(sorted.head == 1)
    assert(sorted(1) == 2)
    assert(sorted(2) == 3)
    assert(sorted(3) == 4)
    assert(sorted(4) == 5)
    assert(sorted(5) == 6)
    assert(sorted(6) == 7)
  }
}
