package DP

/**
 * B. 
 * 1) 
 * Implement an inefficient, brute force, recursive algorithm to compute the Longest
  Common Subsequence of two strings (LCS). 
 * 2) 
 * Copy this implementation and memoize it.
 *
 * 3) 
 * Run both implementations on small input sequences and compare the running times
   (include a counter to count basic operations and print it after computing both versions of LCS).

 * Created by prayagupd on 6/9/15.
 */

object LongestCommonSubseq {

  var bruteForceCalls = 0
  var dpCalls = 0
  var memoizedCalls = 0

  // brute-force recursive version:
  def lcsBruteforceRecursive(seqA: String, seqB: String): String = {
    bruteForceCalls = bruteForceCalls + 1
    //base condition
    if (seqA.size == 0 || seqB.size == 0) ""
    else if (seqA == seqB) seqA

    else
    if (seqA(seqA.size - 1) == seqB(seqB.size - 1))
      lcsBruteforceRecursive(seqA.substring(0, seqA.size - 1), seqB.substring(0, seqB.size - 1)) + seqA(seqA.size - 1)
    else {
      val x = lcsBruteforceRecursive(seqA, seqB.substring(0, seqB.size - 1))
      val y = lcsBruteforceRecursive(seqA.substring(0, seqA.size - 1), seqB)
      if (x.size > y.size) x else y
    }
  }

  //
  //  // brute-force memo version:
  //  def lcsMemoizedRecursive(seqA: String, seqB: String, matrix : Array[Array[Int]]): Int = {
  //    memoizedCalls = memoizedCalls + 1
  //    if (seqA.size==0 || seqB.size==0) 0
  //    else if (seqA==seqB) seqA
  //    else
  //      if(seqA(seqA.size-1)==seqB(seqB.size-1))
  //        matrix(seqA.size)(seqB.size) = lcsBruteforceRecursive(seqA.substring(0,seqA.size-1),seqB.substring(0,seqB.size-1))+seqA(seqA.size-1)
  //      else {
  //        val x = lcsBruteforceRecursive(seqA,seqB.substring(0,seqB.size-1))
  //        val y = lcsBruteforceRecursive(seqA.substring(0,seqA.size-1),seqB)
  //        if (x.size > y.size) x else y
  //      }
  //  }


  // dynamic programming version:
  def lcsDPRecursive(seqA: String, seqB: String): String = {
    dpCalls = dpCalls + 1
    if (seqA.size == 0 || seqB.size == 0) ""
    else if (seqA == seqB) seqA
    else {
      val lengthsMatrix = Array.ofDim[Int](seqA.size+1,seqB.size+1)
      for (i <- 0 until seqA.size)
        for (j <- 0 until seqB.size)
          if (seqA(i) == seqB(j))
            lengthsMatrix(i + 1)(j + 1) = lengthsMatrix(i)(j) + 1
          else
            lengthsMatrix(i + 1)(j + 1) = scala.math.max(lengthsMatrix(i + 1)(j), lengthsMatrix(i)(j + 1))

      // read the substring out from the matrix
      val stringBuilder = new StringBuilder()
      var x = seqA.size
      var y = seqB.size
      do {
        if (lengthsMatrix(x)(y) == lengthsMatrix(x - 1)(y))
          x -= 1
        else if (lengthsMatrix(x)(y) == lengthsMatrix(x)(y - 1))
          y -= 1
        else {
          assert(seqA(x - 1) == seqB(y - 1))
          stringBuilder += seqA(x - 1)
          x -= 1
          y -= 1
        }
      } while (x != 0 && y != 0)
      stringBuilder.toString.reverse
    }
  }

}
