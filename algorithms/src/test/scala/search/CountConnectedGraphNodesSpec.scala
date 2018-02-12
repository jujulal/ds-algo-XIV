package search

import org.scalatest.FunSuite

class CountConnectedGraphNodesSpec extends FunSuite {

  test("2 * 2") {

    val matrix = Array(
      Array(1, 1),
      Array(0, 0)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 2)
  }

  //FIXME for (1,2) -> visited: Vector((0,0), (0,1), (1,0), (1,2), (1,1))
  test("3 * 2") {

    val matrix = Array(
      Array(1, 1, 0),
      Array(0, 1, 1)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 4)
  }

  test("4 * 4") {

    val matrix = Array(
      Array(1, 1, 0, 0),
      Array(0, 1, 1, 0),
      Array(0, 0, 1, 0),
      Array(1, 0, 0, 0)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 5)
  }
}
