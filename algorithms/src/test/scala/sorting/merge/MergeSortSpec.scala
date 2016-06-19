package sorting.merge

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/6/16.
 */

class MergeSortSpec extends FunSuite {
  test("should merge sort the array") {
    val array = Array(13, 10, 0, 13, 3, 28)

    val sorted = MergeSort.startSorting(array)

    assert(sorted.length == 6)
    assert(sorted(0) == 0)
    assert(sorted(1) == 3)
    assert(sorted(2) == 10)
    assert(sorted(3) == 13)
    assert(sorted(4) == 13)
    assert(sorted(5) == 28)
  }
}
