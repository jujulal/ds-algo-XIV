package sorting.bucket

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/19/16.
 */

class BucketSortSpec extends FunSuite {

  test("should sort the array") {
    val givenArray = Array(1, 9, 28, 10, 89, 50)

    val actualArray = BucketSort.sort(givenArray)

    assert(actualArray(0) == 1)
    assert(actualArray(1) == 9)
    assert(actualArray(2) == 10)
    assert(actualArray(3) == 28)
    assert(actualArray(4) == 50)
    assert(actualArray(5) == 89)
  }
}
