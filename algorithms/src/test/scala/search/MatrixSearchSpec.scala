package search

import org.scalatest.FunSuite

class MatrixSearchSpec extends FunSuite {

  test("searches 1 * 1 matrix") {

    val matrix =
      """O""".stripMargin

    val matrixNodes: Array[Array[Char]] = matrix.split("\n").map(_.trim).map(_.split("\\s").map(_.head))

    assert(MatrixSearch.search(matrixNodes, "ORCHEO") == Vector.empty)

  }

  test("searches 2 * 2 matrix") {

    val matrix =
      """O R C H E S
         T R A T O R
         S E R V I C""".stripMargin

    val matrixNodes: Array[Array[Char]] = matrix.split("\n").map(_.trim).map(_.split("\\s").map(_.head))

    assert(MatrixSearch.search(matrixNodes, "ORCHEO") == Vector(
      (0, 0),
      (0, 1),
      (0, 2),
      (0, 3),
      (0, 4),
      (1, 4)
    ))

  }

  test("searches 2 * 2 matrix II") {

    val matrix =
      """O R C H E S
         T R A T O R
         S E R V I C""".stripMargin

    val matrixNodes: Array[Array[Char]] = matrix.split("\n").map(_.trim).map(_.split("\\s").map(_.head))

    assert(MatrixSearch.search(matrixNodes, "HTV") == Vector(
      (0, 3),
      (1, 3),
      (2, 3)
    ))

  }

  test("leetcode testcase") {
    val input =
      """[["A","B","C","E"],
          ["S","F","C","S"],
          ["A","D","E","E"]]""".stripMargin.drop(2).dropRight(2).replaceAll("\"", "")

    val matrix = input.split("],\n").map(_.split(",").map(_.trim.last))

    assert(MatrixSearch.search(matrix, "ABCCE") == Vector((0, 0),
      (0, 1),
      (0, 2),
      (1, 2),
      (2, 2)))
  }

}
