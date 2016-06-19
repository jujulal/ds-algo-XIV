package treeGraphs

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/2/16.
 */

class BalancedTreeSpecs extends FunSuite {

  test("should traverse in pre-order") {

    val root = new BinaryNode[String]("item1",
      left = new BinaryNode[String]("item1-2", left = null, right = new BinaryNode[String]("item1-2-1", null, null)),
      right = new BinaryNode[String]("item1-3", left = null, right = new BinaryNode[String]("item1-3-4", null, null)))

    val inOrderItems = root.realDfsTraverseInPreOrder()

    assert(inOrderItems.size == 5)

    assert(inOrderItems.head == "item1")
    assert(inOrderItems(1) == "item1-2")
    assert(inOrderItems(2) == "item1-2-1")
    assert(inOrderItems(3) == "item1-3")
    assert(inOrderItems(4) == "item1-3-4")

  }

  test("should traverse in-order") {

    val left = new BinaryNode[String]("item2", null, null)
    val right = new BinaryNode[String]("item3", null, new BinaryNode[String]("item4", null, null))
    val root = new BinaryNode[String]("item1", left, right)

    val inOrderItems = root.dfsTraverseInOrder()

    assert(inOrderItems.size == 4)
    assert(inOrderItems.head == "item2")
    assert(inOrderItems(1) == "item1")
    assert(inOrderItems(2) == "item3")
    assert(inOrderItems(3) == "item4")
  }

  test("should traverse in post-order") {

    val left = new BinaryNode[String]("item2", null, null)
    val right = new BinaryNode[String]("item3", null, new BinaryNode[String]("item4", null, null))
    val root = new BinaryNode[String]("item1", left, right)

    val inOrderItems = root.dfsTraverseInPostOrder()

    assert(inOrderItems.size == 4)

    assert(inOrderItems.head == "item2")
    assert(inOrderItems(1) == "item4")
    assert(inOrderItems(2) == "item3")
    assert(inOrderItems(3) == "item1")

  }

  test("isBalanced returns true, given the difference of left and right height is less than or equals to 1") {
    val left = new BinaryNode[String]("item2", null, null)
    val right = new BinaryNode[String]("item3", null, new BinaryNode[String]("item4", null, null))
    val root = new BinaryNode[String]("item1", left, right)

    assert(root.isBalanced)

  }

  test("isBalanced returns true, given the difference of left and right height is greater than 1") {

    val root = new BinaryNode[String]("item1",
      left = new BinaryNode[String]("item2", null, null),
      right = new BinaryNode[String]("item3", null, new BinaryNode[String]("item4", new BinaryNode[String]("item5", null, null), null)))

    assert(!root.isBalanced)

  }

  test("bfs should traverse level-order in a tree") {
    val root = new BinaryNode[String]("item1",
      left = new BinaryNode[String]("item1-2", left = null, right = new BinaryNode[String]("item1-2-1", null, null)),
      right = new BinaryNode[String]("item1-3", left = null, right = new BinaryNode[String]("item1-3-4", null, null)))


    val bfs = root.bfsOrLevelOrderTraversal()

    assert(bfs.size == 5)
    assert(bfs.head == "item1")
    assert(bfs(1) == "item1-2")
    assert(bfs(2) == "item1-3")
    assert(bfs(3) == "item1-2-1")
    assert(bfs.last == "item1-3-4")
  }
}
