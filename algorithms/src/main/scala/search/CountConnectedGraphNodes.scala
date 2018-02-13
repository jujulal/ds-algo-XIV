package search

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * Easy
  *
  * https://leetcode.com/problems/max-area-of-island/description/
  *
  * https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
  */

object CountConnectedGraphNodes {

  def isValid(rc: (Int, Int), rowSize: Int, colSize: Int): Boolean =
    if (rc._1 < 0 || rc._2 < 0 || rc._1 > rowSize - 1 || rc._2 > colSize - 1) false
    else true

  def findNeighbourNodes(node: (Int, Int), rowSize: Int, colSize: Int): IndexedSeq[(Int, Int)] = {

    val row = node._1
    val col = node._2

    IndexedSeq((row, col - 1), (row - 1, col - 1),
      (row - 1, col), (row - 1, col + 1),
      (row, col + 1), (row + 1, col + 1),
      (row + 1, col), (row + 1, col - 1)).filter(isValid(_, rowSize, colSize))

  }

  def connected(matrix: Array[Array[Int]]): Int = {

    val visitedNodes = scala.collection.mutable.ArrayBuffer.empty[(Int, Int)]

    var neighboursMap = scala.collection.mutable.Map.empty[(Int, Int), IndexedSeq[(Int, Int)]]

    for (r <- 0 until matrix.length) {
      for (c <- 0 until matrix(r).length) {

        if (!visitedNodes.contains((r, c))) {
          visitedNodes += ((r, c))

          if (matrix(r)(c) == 1) {
            val neighboursQueue = new java.util.LinkedList[(Int, Int)]()
            var connectedNodesForCurrentNode = scala.collection.mutable.ArrayBuffer((r, c))

            findNeighbourNodes((r, c), matrix.length, matrix.head.length).foreach(neighboursQueue.add)

            while (!neighboursQueue.isEmpty) {
              val neighbour = neighboursQueue.poll()
              if (!visitedNodes.contains(neighbour)) {
                visitedNodes += ((neighbour._1, neighbour._2))
                if (matrix(neighbour._1)(neighbour._2) == 1) {
                  connectedNodesForCurrentNode += ((neighbour._1, neighbour._2))
                  findNeighbourNodes((neighbour._1, neighbour._2), matrix.length, matrix.head.length).foreach(neighboursQueue.add)
                }
              }
            }

            neighboursMap += ((r, c) -> connectedNodesForCurrentNode)
          }
        }
      }
    }

    val sizes = neighboursMap.values.map(_.size)
    if (sizes.isEmpty) 0
    else sizes.max
  }
}
