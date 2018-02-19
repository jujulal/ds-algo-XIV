package arrays

/**
  * Easy, https://www.hackerrank.com/challenges/saveprincess?hr_b=1
  * Hard, https://leetcode.com/problems/dungeon-game/description/
  */

object MatrixTraversal {

  private def move(knightPosition: (Int, Int, IndexedSeq[String]), princessPosition: (Int, Int)): IndexedSeq[String] = {

    if (knightPosition._1 == princessPosition._1 && knightPosition._2 == princessPosition._2)
      knightPosition._3

    else if (princessPosition._1 < knightPosition._1)
      move((knightPosition._1 - 1, knightPosition._2, knightPosition._3 :+ "UP"), princessPosition)

    else if (princessPosition._1 > knightPosition._1)
      move((knightPosition._1 + 1, knightPosition._2, knightPosition._3 :+ "DOWN"), princessPosition)

    else if (princessPosition._2 < knightPosition._2)
      move((knightPosition._1, knightPosition._2 - 1, knightPosition._3 :+ "LEFT"), princessPosition)

    else
      move((knightPosition._1, knightPosition._2 + 1, knightPosition._3 :+ "RIGHT"), princessPosition)

  }

  def findPosition(char: Char, row: Int, grid: Array[String]): (Int, Int) = {
    if (grid(row).contains(char)) (row, grid(row).indexOf(char))
    else findPosition(char, row + 1, grid)
  }

  def displayPathToPrincess(m: Int, grid: Array[String]): String = {
    val knightPos = findPosition('m', 0, grid)

    val knight = (knightPos._1, knightPos._2, IndexedSeq.empty)

    val princess = findPosition('p', 0, grid)

    move(knight, princess).mkString("\n")
  }

}
