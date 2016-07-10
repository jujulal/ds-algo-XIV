package DP

import java.util.Date

/**
 * Created by prayagupd
 * on 5/28/15.
 */

object Fibonacci {

  var cache = scala.collection.immutable.Map[Long, BigInt]()

  def fibonacci(num: Long): BigInt = {
    if (num == 1) {
      return 1
    }

    if (num == 2) {
      return 1
    }
    var fib1: BigInt = 0
    var fib2: BigInt = 0

    if (cache.contains(num - 1)) {
      val n1 = num - 1
      fib1 = cache.get(num - 1).get
      println(s"#1 cache for fib(${num}) = ${fib1}")
    } else {
      fib1 = fibonacci(num - 1)
      cache += num - 1 -> fib1
    }

    if (cache.contains(num - 2)) {
      val n2 = num - 2
      fib2 = cache.get(num - 2).get
      println(s"#2 for ${num} from cache,  fib(${n2}) = ${fib2}")
    } else {
      fib2 = fibonacci(num - 2)
      cache += num - 2 -> fib2
    }

    cache += num -> (fib1 + fib2)
    //println(s"fib=${fib1}+${fib2}")
    fib1 + fib2

  }

  def main(args: Array[String]) {
    print("input : ")
    val input = readLong()
    val startTime: Long = System.currentTimeMillis()
    val fib = fibonacci(input)
    //println(s"${input}th fib = ${fib}")
    val endTime: Long = System.currentTimeMillis()
    val time = (endTime - startTime) / 1000 //
    println(s"Time taken for ${fib} = ${time} seconds")

    //30 832040
    //40 102334155
    //45 1134903170 //29secs
    //48 4807526976
    //49 7778742049
    //fib(50) = 12586269025
  }
}

