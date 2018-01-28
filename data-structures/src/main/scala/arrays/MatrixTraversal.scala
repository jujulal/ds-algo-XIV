package arrays

/**
  * https://www.hackerrank.com/challenges/saveprincess?hr_b=1
  */

object MatrixTraversal {

  def move(guardPosition: (Int, Int, IndexedSeq[String]), princessPosition: (Int, Int)): IndexedSeq[String] = {

    if (guardPosition._1 == princessPosition._1 && guardPosition._2 == princessPosition._2) {
      guardPosition._3

    } else if (princessPosition._1 < guardPosition._1) {
      move((guardPosition._1 - 1, guardPosition._2, guardPosition._3 :+ "UP"), princessPosition)

    } else if (princessPosition._1 > guardPosition._1) {
      move((guardPosition._1 + 1, guardPosition._2, guardPosition._3 :+ "DOWN"), princessPosition)

    } else if (princessPosition._2 < guardPosition._2) {
      move((guardPosition._1, guardPosition._2 - 1, guardPosition._3 :+ "LEFT"), princessPosition)

    } else {
      move((guardPosition._1, guardPosition._2 + 1, guardPosition._3 :+ "RIGHT"), princessPosition)
    }

  }

  def displayPathtoPrincess(m: Int, grid: Array[String]): String = {

    val guard = (m / 2, m / 2, IndexedSeq.empty)

    val princess = if (grid(0).contains("p")) {
      (0, grid(0).indexOf("p"))
    } else {
      (m - 1, grid(m - 1).indexOf("p"))
    }

    move(guard, princess).mkString("\n")
  }

  def main(args: Array[String]): Unit = {
    val m = Console.readLine.toInt
    val grid = new Array[String](m)
    for (i <- 0 until m) {
      grid.update(i, Console.readLine)
    }

    println(displayPathtoPrincess(m, grid))
  }

}
