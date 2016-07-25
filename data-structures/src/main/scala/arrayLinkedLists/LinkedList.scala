package arrayLinkedLists

/**
 * Created by prayagupd
 * on 6/5/16.
 */

case class Node[T](var data: T = null, var next: LinkedNode[T] = null)

case class LinkedList[T](var root: LinkedNode[T] = null) {

  def add (data : T ): Boolean = {
    var lastNode = root
    if(lastNode != null) {
      while (lastNode.next != null) {
        lastNode = lastNode.next
      }
      lastNode.next = new LinkedNode[T](data, null)
    } else {
      root = new LinkedNode[T](data, null)
    }
    true
  }

  def size: Int = {
    var currentNode = root
    var size = 0
    while (currentNode != null) {
      size = size + 1
      currentNode = currentNode.next
    }
    size
  }

  def get(index: Int): T = {
    var searchNode = root
    var sizeCounter = 0
    while (searchNode != null) {
      if (sizeCounter == index) {
        return searchNode.data
      }
      searchNode = searchNode.next
      sizeCounter = sizeCounter + 1
    }
    throw new IllegalArgumentException(s"Wrong index, list is of size $size")
  }

  def head: T = {
    get(0)
  }

  def last: T = {
    get(size-1)
  }

  def next(next: LinkedNode[T]) : Unit = {
    root.next = next
  }

  def reverse(currentNode: LinkedNode[T]) : LinkedNode[T] = {
    if(currentNode==null || currentNode.next == null)
      return currentNode

    //get second node
    val nextNode = currentNode.next
    //set first's next to be null
    currentNode.next = null

    val rest = reverse(nextNode)
    nextNode.next = currentNode

    rest
  }
}
