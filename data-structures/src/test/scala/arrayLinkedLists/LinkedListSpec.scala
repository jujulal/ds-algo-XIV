package arrayLinkedLists

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/5/16.
 */

class LinkedListSpec extends FunSuite {

  test("linkedlist should store and retrieve the values") {
    val linkedList = new LinkedList[String]()
    linkedList.add("manhattan warehouse")
    linkedList.add("columbus warehouse")

    assert(linkedList.size == 2)

    assert(linkedList.head == "manhattan warehouse")
    assert(linkedList.last == "columbus warehouse")

  }
}
