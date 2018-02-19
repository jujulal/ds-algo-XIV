package DP

import DP.LongestCommonSubseq.{bruteForceCalls, dpCalls, lcsBruteforceRecursive, lcsDPRecursive}
import org.scalatest.FunSuite

class LongestCommonSubseqSpec extends FunSuite {


  test("lcs") {

    val elapsed: (=> Unit) => Long = fn => {
      val s = System.currentTimeMillis
      fn
      (System.currentTimeMillis - s) / 1000
    }

    def timeTaken(callback: () => Long) {
      val s = System.currentTimeMillis
      callback
      (System.currentTimeMillis - s) / 1000
    }

    val pairs1 = List(("GAATTCAGTTA", "GGATCGA"))
    val pairs2 = List(("cababc", "abdcb"))

    var s = ""
    println("recursive version:")
    pairs2 foreach { pair =>
      val start = System.currentTimeMillis()
      val s = lcsBruteforceRecursive(pair._1, pair._2)
      val time = (System.currentTimeMillis() - start) / 1000
      println {
        "lcsBruteforceRecursive(\"" + pair._1 + "\",\"" + pair._2 + "\") = \"" + s + "\"   (" + time + " sec)"
      }
      println(s"rec calls = $bruteForceCalls")
    }

    println("\n" + "dynamic programming version:")
    pairs2 foreach { pair =>
      //val lengthsMatrix = Array.ofDim[Int](pair._1.size+1, pair._1.size+1)
      val start = System.currentTimeMillis()
      val s = lcsDPRecursive(pair._1, pair._2)
      val time = (System.currentTimeMillis() - start) / 1000
      println {
        "lcsDPRecursive(\"" + pair._1 + "\",\"" + pair._2 + "\") = \"" + s + "\"   (" + time + " sec)"
      }
      println(s"rec calls = $dpCalls")
    }
  }

}
