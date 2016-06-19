package treeGraph

import java.util.ArrayList
import java.util.Collections
import java.util.List
import java.util.PriorityQueue

/**
 * Created by prayagupd
 * on 6/12/16.
 */

class Vertex extends Comparable[Vertex] {
  var name: String = null
  var adjacencies: Array[Edge] = null
  var minDistance: Double = Double.PositiveInfinity
  var previous: Vertex = null

  def this(n: String) {
    this()
    name = n
  }

  override def toString: String = name

  def compareTo(other: Vertex): Int = minDistance compareTo other.minDistance
}

class Edge {
  var target: Vertex = null
  var weight: Double = .0

  def this(argTarget: Vertex, argWeight: Double) {
    this()
    target = argTarget
    weight = argWeight
  }
}

object ShortestPath {
  def computePaths(source: Vertex) : Unit = {
    source.minDistance = 0

    val vertexQueue: PriorityQueue[Vertex] = new PriorityQueue[Vertex]
    vertexQueue.add(source)

    while (!vertexQueue.isEmpty) {
      val vertex1: Vertex = vertexQueue.poll
      for (edge1 <- vertex1.adjacencies) {
        val vertex2: Vertex = edge1.target
        val weightForEdgeFromVertex1: Double = edge1.weight
        val distanceThroughVertex1: Double = vertex1.minDistance + weightForEdgeFromVertex1
        if (distanceThroughVertex1 < vertex2.minDistance) {
          vertexQueue.remove(vertex2)
          vertex2.minDistance = distanceThroughVertex1
          vertex2.previous = vertex1
          vertexQueue.add(vertex2)
        }
      }
    }
  }

  def getShortestPathTo(targetVertex: Vertex): List[Vertex] = {
    val path: List[Vertex] = new ArrayList[Vertex]
    var targetVertexx: Vertex = targetVertex
    while (targetVertexx != null) {
      path.add(targetVertexx)
      targetVertexx = targetVertexx.previous
    }
    Collections.reverse(path)
    path
  }
}