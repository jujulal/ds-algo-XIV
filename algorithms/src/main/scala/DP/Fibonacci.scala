package DP

import java.util.Date

/**
  * Created by prayagupd
  * on 5/28/15.
  */

object Fibonacci {

  var fibCache: Map[Long, BigInt] = scala.collection.immutable.Map[Long, BigInt]()

  def fibonacci(num: Long): BigInt = {

    if (num == 1) return 1
    if (num == 2) return 1

    var fib1: BigInt = 0
    var fib2: BigInt = 0

    if (fibCache.contains(num - 1)) {
      fib1 = fibCache(num - 1)
    } else {
      fib1 = fibonacci(num - 1)
      fibCache += num - 1 -> fib1
    }

    if (fibCache.contains(num - 2)) {
      fib2 = fibCache(num - 2)
    } else {
      fib2 = fibonacci(num - 2)
      fibCache += num - 2 -> fib2
    }

    fibCache += num -> (fib1 + fib2)
    fib1 + fib2

  }
}
