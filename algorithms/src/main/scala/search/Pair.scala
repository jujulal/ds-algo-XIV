package search

/**
  * https://www.hackerrank.com/challenges/pairs/problem
  *
  * Input:
  * k=2
  * 1 5 3 4 2
  *
  * Output:
  * 3
  */

object Pair {

  //Array
  def diffPairs(array: Array[Int], diff: Int): Long = {

    def pair(arr: Array[Int]): Int = {
      if (arr.isEmpty) 0
      else arr.collect { case x if Math.abs(x - arr.head) == diff => 1 }.sum + pair(arr.slice(1, arr.length))
    }

    pair(array)
  }

  //Seq
  def diffPairsUsingSeq(array: Seq[Int], diff: Int): Long = {

    def pair(a: Seq[Int]): Int = {
      a match {
        case Nil => 0
        case head :: tail => tail.collect { case x if Math.abs(x - head) == diff => 1 }.sum + pair(tail)
      }
    }

    pair(array)
  }
}
