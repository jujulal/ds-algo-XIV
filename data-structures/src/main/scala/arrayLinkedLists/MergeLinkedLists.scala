package arrayLinkedLists

import scala.collection.mutable
import scala.util.control.Breaks._

/**
 * Created by prayagupd
 * on 6/5/16.
 */


case class LinkedNode[T](var data: T = null, var next: LinkedNode[T] = null) {

  def +=(data : T) : Boolean = {
    true
  }

  def size : Int = {
    0
  }

  def get(index: Int) : T = {
    data
  }

  def head: T = {
    get(0)
  }

  def last: T = {
    get(size - 1)
  }
}

object MergeLinkedLists {

  def merge(list1: LinkedNode[String], list2: LinkedNode[String]): LinkedNode[String] = {
    var l1 = list1
    var l2 = list2

    val head = new LinkedNode[String]()

    var p = head

    breakable {
      while (atleastOneListNonEmpty(l1, l2)) {
        if (bothNonEmpty(l1, l2)) {
          if (l1.data < l2.data) {
            p.next = l1
            l1 = l1.next
          } else {
            p.next = l2
            l2 = l2.next
          }
          p = p.next
        } else if (l1 == null) {
          p.next = l2
          break()
        } else if (l2 == null) {
          p.next = l1
          break()
        }
      }
    }

    head.next
  }

  private def bothNonEmpty(l1: LinkedNode[String], l2: LinkedNode[String]): Boolean = {
    l1 != null && l2 != null
  }

  private def atleastOneListNonEmpty(l1: LinkedNode[String], l2: LinkedNode[String]): Boolean = {
    l1 != null || l2 != null
  }
}
