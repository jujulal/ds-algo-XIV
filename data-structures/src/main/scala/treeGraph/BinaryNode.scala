package treeGraphs

import java.lang.Math.abs

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 4.1
  Implement a function to check if a tree is balanced. 
  A balanced tree is defined to be a tree such that no two leaf nodes differ in distance
  from the root by more than one.
 *
 *     PT
     /    \
    PF      Opeth
   /    /         \
  SW   Architects  Enter Shikari
      /
     BMTH
 * https://webdocs.cs.ualberta.ca/~holte/T26/balanced-trees.html
 */

case class BinaryNode[T](
                          var data: T,
                          var left: BinaryNode[T],
                          var right: BinaryNode[T]) {

  override def toString: String = data.toString


  /**
   * root, left, right
   * algo : store left and right children,
   * and push right child first so that it is processed after the left child.
   * http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/
   *
   * https://www.youtube.com/watch?v=AfSk24UTFS8&index=66&list=PL40361139FDD683CE
   *
   */
  def realDfsTraverseInPreOrder(): ArrayBuffer[T] = {

    if (this == null)
      return ArrayBuffer.empty[T]

    val stackOfRightAndLeftNodes: mutable.Stack[BinaryNode[T]] = new mutable.Stack[BinaryNode[T]]() // Space(nodes)
    stackOfRightAndLeftNodes.push(this) // time(1)

    val traversedNodes: ArrayBuffer[T] = new ArrayBuffer[T]()  // Space(nodes)

    while (stackOfRightAndLeftNodes.nonEmpty) {
      val currentNode = stackOfRightAndLeftNodes.pop()
      traversedNodes.+=(currentNode.data)

      if (hasRightChild(currentNode)) {
        stackOfRightAndLeftNodes.push(currentNode.right)
      }
      if (hasLeftChild(currentNode)) {
        stackOfRightAndLeftNodes.push(currentNode.left)
      }
    }
    traversedNodes
  }

  /**
   * left, root, right
   * http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
   */
  def dfsTraverseInOrder(): ArrayBuffer[T] = {
    val listOfNodes = new ArrayBuffer[T]()

    val stackOfLeftFirstNodesFollowedByRight = new mutable.Stack[BinaryNode[T]]()
    var currentNode = this

    while (stackOfLeftFirstNodesFollowedByRight.nonEmpty || notEmpty(currentNode)) {

      if (notEmpty(currentNode)) {
        stackOfLeftFirstNodesFollowedByRight.push(currentNode)
        currentNode = currentNode.left
      } else {
        //pop & add to traversal list
        val mostRecentNode = stackOfLeftFirstNodesFollowedByRight.pop()
        addToTraversalList(mostRecentNode)
        currentNode = mostRecentNode.right
      }
    }

    def addToTraversalList(node: BinaryNode[T]): Unit = {
      listOfNodes.+=(node.data)
    }

    listOfNodes
  }

  /**
   * left, right, root
   * http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
   */
  def dfsTraverseInPostOrder(): ArrayBuffer[T] = {
    val traversedNodes = new ArrayBuffer[T]()

    if (this == null) return traversedNodes

    val stackOfRootRightAndThenLeftNodes = new mutable.Stack[BinaryNode[T]]()
    stackOfRootRightAndThenLeftNodes.push(this)

    while (stackOfRootRightAndThenLeftNodes.nonEmpty) {
      val currentNode = stackOfRootRightAndThenLeftNodes.top

      if (isLeafNode(currentNode)) {
        traversedNodes.+=(stackOfRootRightAndThenLeftNodes.pop().data)
      } else {
        if (hasRightChild(currentNode)) {
          stackOfRootRightAndThenLeftNodes.push(currentNode.right)
          currentNode.right = null
        }

        if (hasLeftChild(currentNode)) {
          stackOfRootRightAndThenLeftNodes.push(currentNode.left)
          currentNode.left = null
        }
      }
    }

    traversedNodes
  }

  def isBalanced: Boolean = {
    if(this == null) return true
    if(abs(height(this.left) - height(this.right)) <=1 ) return true
    false
  }

  def height(node: BinaryNode[T]) : Int =  {
    if(node == null) return 0
    1 + Math.max(height(node.left), height(node.right))
  }

  def hasLeftChild(currentNode: BinaryNode[T]): Boolean = {
    currentNode.left != null
  }

  def hasRightChild(currentNode: BinaryNode[T]): Boolean = {
    currentNode.right != null
  }

  def isLeafNode(currentNode: BinaryNode[T]): Boolean = {
    currentNode.left == null && currentNode.right == null
  }

  def notEmpty(currentNode: BinaryNode[T]): Boolean = {
    currentNode != null
  }

  /**
   *
   * 13. Breadth-First Search (BFS), Erik Demaine,
   * https://www.youtube.com/watch?v=s-CYnVz-uh4&index=65&list=PL40361139FDD683CE
   */
  def bfsOrLevelOrderTraversal() : ArrayBuffer[T] = {
    val queueOfLeftRightNodes = new mutable.Queue[BinaryNode[T]]()
    queueOfLeftRightNodes.enqueue(this)

    val traversedNodes = new ArrayBuffer[T]()

    while(queueOfLeftRightNodes.nonEmpty) {
      val topNode = queueOfLeftRightNodes.dequeue()
      if(notEmpty(topNode)) {
        traversedNodes.+=(topNode.data)
        queueOfLeftRightNodes.enqueue(topNode.left)
        queueOfLeftRightNodes.enqueue(topNode.right)
      }
    }

    traversedNodes
  }
  /**
   * 4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
   */
  def findARouteBetweenNodes(): Unit = {

  }
}

