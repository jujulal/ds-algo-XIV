package search

/**
  * https://www.hackerrank.com/challenges/pairs/problem
  */

object Pair {

  def diffPairs(array: Seq[Int], diff: Int): Long = {

    def pair(a: Seq[Int]): Int = {
      a match {
        case Nil => 0
        case head :: tail => tail.collect { case x if Math.abs(x - head) == diff => 1 }.sum + pair(tail)
      }
    }

    pair(array)
  }

  def diffPairs(array: Array[Int], diff: Int): Long = {

    def pair(a: Array[Int]): Int = {
      if(a.isEmpty) 0
      else {
        a.collect { case x if Math.abs(x - a.head) == diff => 1}.sum + pair(a.slice(1, a.length))
      }
    }

    pair(array)
  }

}
