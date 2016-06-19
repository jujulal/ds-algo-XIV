package arraysLinkedLists

import scala.collection.mutable

//import scala.collection.mutable.LinkedList

/**
 *
 * 2.1
 * Write code to remove duplicates from an unsorted linked list.
 *
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * Ref : https://gist.github.com/xchuang/8167437
 * http://stackoverflow.com/a/20033310/432903 - O(n)
 */

object RemoveDuplicates {

  def removeDuplicates(linkedList: mutable.LinkedList[String]): mutable.LinkedList[String] = {

    val hashTable = mutable.HashMap.empty[String, Boolean]

    linkedList.zipWithIndex.foreach { case (item, index) =>
      if (hashTable.contains(item)) {
        var current = linkedList.drop(index - 1) //do nth-2
        //set the 'next' -> 'next of deleted element'
        current.next = current.next.next
        println(s"After removing $index(-2) => $current")
      } else {
        hashTable += (item -> true)
      }
    }

    linkedList
  }
}
