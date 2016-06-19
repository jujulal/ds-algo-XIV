package treeGraphs

import java.util
import java.util.List

import org.scalatest.FunSuite
import treeGraph.Vertex
import treeGraph.Edge
import treeGraph.ShortestPath

/**
 * Created by prayagupd
 * on 6/12/16.
 */

class ShortestPatSpec extends FunSuite {
  test("should find shortest path") {
    //given
    val A: Vertex = new Vertex("A")
    val B: Vertex = new Vertex("B")
    val D: Vertex = new Vertex("D")
    val F: Vertex = new Vertex("F")
    val K: Vertex = new Vertex("K")
    val J: Vertex = new Vertex("J")
    val M: Vertex = new Vertex("M")
    val O: Vertex = new Vertex("O")
    val P: Vertex = new Vertex("P")
    val R: Vertex = new Vertex("R")
    val Z: Vertex = new Vertex("Z")
    A.adjacencies = Array[Edge](new Edge(M, 8))
    B.adjacencies = Array[Edge](new Edge(D, 11))
    D.adjacencies = Array[Edge](new Edge(B, 11))
    F.adjacencies = Array[Edge](new Edge(K, 23))
    K.adjacencies = Array[Edge](new Edge(O, 40))
    J.adjacencies = Array[Edge](new Edge(K, 25))
    M.adjacencies = Array[Edge](new Edge(R, 8))
    O.adjacencies = Array[Edge](new Edge(K, 40))
    P.adjacencies = Array[Edge](new Edge(Z, 18))
    R.adjacencies = Array[Edge](new Edge(P, 15))
    Z.adjacencies = Array[Edge](new Edge(P, 18))

    //when
    ShortestPath.computePaths(A)

    //then
    println("Distance to " + Z + ": " + Z.minDistance)
    val path: List[Vertex] = ShortestPath.getShortestPathTo(Z)
    println("Path: " + path)

    assert(path == util.Arrays.asList((A, M, R, P, Z)))
  }
}
