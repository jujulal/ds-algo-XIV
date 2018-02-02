package arrays

import org.scalatest.FunSuite

class MatrixTraversalSpec extends FunSuite {


  test("traverse matrix in 3*3") {
    val matrix = Array(
      new String("---"),
      new String("-m-"),
      new String("p--"))

    assert(MatrixTraversal.displayPathtoPrincess(3, matrix) == "DOWN\nLEFT")
  }

  test("traverse matrix in 5*5") {
    val matrix = Array(
      new String("-----"),
      new String("-----"),
      new String("--m--"),
      new String("-----"),
      new String("p----"))

    assert(MatrixTraversal.displayPathtoPrincess(5, matrix) == "DOWN\nDOWN\nLEFT\nLEFT")
  }

  test("traverse matrix in 5*5 II") {
    val matrix = Array(
      new String("-----"),
      new String("-----"),
      new String("p--m-"),
      new String("-----"),
      new String("-----"))

    assert(MatrixTraversal.displayPathtoPrincess(5, matrix) == "LEFT\nLEFT\nLEFT")
  }
}
