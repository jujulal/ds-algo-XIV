package sorting.bucket

import org.scalatest.{FunSuite, Matchers}

/**
 * Created by prayagupd
 * on 6/19/16.
 */

class BucketSortSpec extends FunSuite with Matchers {

  test("should sort the array 1") {
    val givenArray = Array(1, 9, 28, 10, 89, 50)

    val actualArray = BucketSort.sort(givenArray)

    actualArray(0) shouldBe 1
    actualArray(1) shouldBe 9
    actualArray(2) shouldBe 10
    actualArray(3) shouldBe 28
    actualArray(4) shouldBe 50
    actualArray(5) shouldBe 89
  }

  test("should sort the array 2") {
    val givenArray = Array(1, 9, 28, 27, 10, 89, 50)

    val actualArray = BucketSort.sort(givenArray)

    actualArray(0) shouldBe 1
    actualArray(1) shouldBe 9
    actualArray(2) shouldBe 10
    actualArray(3) shouldBe 27
    actualArray(4) shouldBe 28
    actualArray(5) shouldBe 50
    actualArray(6) shouldBe 89
  }
}
