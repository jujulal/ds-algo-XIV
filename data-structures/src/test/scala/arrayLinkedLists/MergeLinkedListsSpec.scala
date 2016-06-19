package arrayLinkedLists

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/5/16.
 */

class MergeLinkedListsSpec extends FunSuite {

  test("should merge two lists") {
    val list1 = new LinkedNode[String]()
    list1.+=("blue shirt")
    list1.+=("yellow jeans")

    val list2 = new LinkedNode[String]()
    list2.+=("green short")
    list2.+=("red underwear")

    val merged = MergeLinkedLists.merge(list1, list2)

    assert(merged.size == 4)
    assert(merged.head == "blue shirt")
    assert(merged.get(1) == "green short")
    assert(merged.get(2) == "red underwear")
    assert(merged.last == "yellow jeans")
  }
}
