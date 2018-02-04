package search

import org.scalatest.FunSuite

class DeterministicBotCleanSpecs extends FunSuite {

  test("find the dirt") {

    val grid = Array(
      "bd---",
      "-d---",
      "---d-",
      "---d-",
      "--d-d")

    assert(DeterministicBotClean.nextMove("0 0", grid) == "RIGHT")

  }
}
