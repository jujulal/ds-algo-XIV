package search

import scala.collection.mutable.ArrayBuffer

/**
  * https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
  */

object CountConnectedGraphNodes {

  def isValid(rc: (Int, Int), rowSize: Int, colSize: Int): Boolean =
    if (rc._1 < 0 || rc._2 < 0
      || rc._1 > rowSize - 1 || rc._2 > colSize - 1) false
    else true

  def findConnectedNodes(node: (Int, Int), rowSize: Int, colSize: Int): IndexedSeq[(Int, Int)] = {

    val r = node._1
    val c = node._2

    IndexedSeq((c - 1, r),
      (c - 1, r - 1),
      (r - 1, c),
      (r - 1, c + 1),
      (r, c + 1),
      (r + 1, c + 1),
      (r + 1, c),
      (r + 1, c - 1)).filter(isValid(_, rowSize, colSize))

  }

  def connectedNodes(matrix: Array[Array[Int]], currentNode: (Int, Int), connected: Int, visited: IndexedSeq[(Int, Int)]): Int = {

    if (matrix(currentNode._1)(currentNode._2) == 0 || visited.contains(currentNode)) connected

    else {
      val nodes = findConnectedNodes(currentNode, matrix.length, matrix(0).length)

      val sum = nodes.zipWithIndex.map { case (neighbourNode, index) =>
        if (index == 0) connectedNodes(matrix, neighbourNode, connected, visited :+ currentNode)
        else connectedNodes(matrix, neighbourNode, connected, (visited :+ currentNode) ++ findConnectedNodes(nodes(index - 1), matrix.length, matrix(0).length))
      }.sum

      1 + sum
    }

  }

  def connected(matrix: Array[Array[Int]]): Int = {

    val connectedNodess = new ArrayBuffer[Int]()

    for (r <- 0 until matrix.length) {
      for (c <- 0 until matrix(r).length) {
        connectedNodess += connectedNodes(matrix, (0, 0), 0, IndexedSeq.empty)
      }
    }

    println(connectedNodess)
    connectedNodess.max
  }
}
