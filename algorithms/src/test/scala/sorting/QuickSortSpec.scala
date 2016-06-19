package sorting

import org.scalatest.FunSuite
import sorting.heap.HeapSort
import sorting.quick.QuickSort

/**
 * Created by prayagupd
 * on 6/8/16.
 */

class QuickSortSpec extends FunSuite {
  test("should sort the array using quick sort algo") {

    val array = Array(13, 10, 0, 13, 3)

    val sorted = QuickSort.startSorting(array)

    assert(sorted(0) == 0)
    assert(sorted(1) == 3)
    assert(sorted(2) == 10)
    assert(sorted(3) == 13)
    assert(sorted(4) == 13)

  }
}
