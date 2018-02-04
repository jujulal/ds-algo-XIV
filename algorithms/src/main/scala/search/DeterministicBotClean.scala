package search

/**
  * https://www.hackerrank.com/challenges/botclean
  */

object DeterministicBotClean {

  case class Dirt(r: Int, c: Int)

  def dirts(grid: Array[String]): IndexedSeq[Dirt] = {
    grid.zipWithIndex.flatMap { case (row, r) =>
      row.zipWithIndex.flatMap { case (col, c) =>
        if (col == 'd') Some(Dirt(r, c))
        else None
      }
    }
  }

  def nextMove(pos: String, board: Array[String]): String = {
    val botPosition = pos.split(" ").map(_.toInt)

    val firstDirt = dirts(board).head

    if (firstDirt.c > botPosition.last) "RIGHT"
    else if (firstDirt.c < botPosition.last) "LEFT"
    else if (firstDirt.r > botPosition.head) "DOWN"
    else if (firstDirt.r < botPosition.head) "UP"
    else "CLEAN"
  }

}
