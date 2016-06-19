package sorting.heap

import org.scalatest._
import sorting.merge.MergeSort

import scala.collection.mutable.Stack

class HeapSortSpec extends FlatSpec {

  "array" should "be heap sorted" in {

    val array = Array(13, 10, 0, 13, 3)

    val sorted = HeapSort.sort(array)

    assert(sorted(0) == 0)
    assert(sorted(1) == 3)
    assert(sorted(2) == 10)
    assert(sorted(3) == 13)
    assert(sorted(4) == 13)

  }
}
