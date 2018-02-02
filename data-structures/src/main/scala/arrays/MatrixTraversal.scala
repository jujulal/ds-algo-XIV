package arrays

/**
  * https://www.hackerrank.com/challenges/saveprincess?hr_b=1
  */

object MatrixTraversal {

  def move(guardPosition: (Int, Int, IndexedSeq[String]), princessPosition: (Int, Int)): IndexedSeq[String] = {

    if (guardPosition._1 == princessPosition._1 && guardPosition._2 == princessPosition._2)
      guardPosition._3

    else if (princessPosition._1 < guardPosition._1)
      move((guardPosition._1 - 1, guardPosition._2, guardPosition._3 :+ "UP"), princessPosition)

    else if (princessPosition._1 > guardPosition._1)
      move((guardPosition._1 + 1, guardPosition._2, guardPosition._3 :+ "DOWN"), princessPosition)

    else if (princessPosition._2 < guardPosition._2)
      move((guardPosition._1, guardPosition._2 - 1, guardPosition._3 :+ "LEFT"), princessPosition)

    else
      move((guardPosition._1, guardPosition._2 + 1, guardPosition._3 :+ "RIGHT"), princessPosition)

  }

  def find(char: Char, row: Int, grid: Array[String]): (Int, Int) = {
    if (grid(row).contains(char)) (row, grid(row).indexOf(char))
    else find(char, row + 1, grid)
  }

  def displayPathtoPrincess(m: Int, grid: Array[String]): String = {
    val guardPos = find('m', 0, grid)

    val guard = (guardPos._1, guardPos._2, IndexedSeq.empty)

    val princess = find('p', 0, grid)

    move(guard, princess).mkString("\n")
  }

}
