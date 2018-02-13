package search

import org.scalatest.FunSuite

class CountConnectedGraphNodesSpec extends FunSuite {

  test("0") {

    val matrix = Array(
      Array(0)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 0)
  }

  test("1") {

    val matrix = Array(
      Array(1)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 1)
  }

  test("1 * 1") {

    val matrix = Array(
      Array(1),
      Array(0)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 1)
  }

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

  test("3 * 3 but 1 in 0 col") {

    val matrix = Array(
      Array(1, 1, 0),
      Array(0, 0, 1),
      Array(1, 1, 1)
    )

    assert(CountConnectedGraphNodes.connected(matrix) == 6)
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

  test("8 * 9") {

    """0 1   0   0     0     0   X10 X1
       0 1   1   0     0     X11 0   0
       0 1   0   0     0     0   X9  0
       1 0   0   0     X17   X12 X8 0
       1 0   X26 X18   0     X13 X7 X2
       0 0   X25 X19   0     0 X6 0
       X29   X27 0     X2    0   X16 0 0 X3
       0 0   X24 X21   0     X14 X5 X4
       0 X28 X23 X22   X15   0 0 0""".stripMargin

    val matrixStr =
    """0 1 0 0 0 0 1 1
       0 1 1 0 0 1 0 0
       0 1 0 0 0 0 1 0
       1 0 0 0 1 1 1 0
       1 0 1 1 0 1 1 1
       0 0 1 1 0 0 1 0
       1 1 0 1 1 0 0 1
       0 0 1 1 0 1 1 1
       0 1 1 1 1 0 0 0""".stripMargin

    val matrix: Array[Array[Int]] = matrixStr.split("\n").map(x => x.trim.split("\\s+").map(_.toInt))

    assert(CountConnectedGraphNodes.connected(matrix) == 29)
  }

  test("test case#5 -  7 * 5") {

    val matrixStr =
      """1 1 1 0 1
         0 0 1 0 0
         1 1 0 1 0
         0 1 1 0 0
         0 0 0 0 0
         0 1 0 0 0
         0 0 1 1 0""".stripMargin

    val matrix: Array[Array[Int]] = matrixStr.split("\n").map(x => x.trim.split("\\s+").map(_.toInt))

    assert(CountConnectedGraphNodes.connected(matrix) == 9)
  }
}
