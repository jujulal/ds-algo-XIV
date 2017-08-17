package DP

import scala.collection.mutable.ArrayBuffer
import scala.math._

/**
  * https://www.hackerrank.com/challenges/fibonacci-fp
  * Created by prayagupd
  * on 5/28/15.
  */

object FibonacciSeries {

  var cache = scala.collection.immutable.Map[Int, BigInt]()

  def fibonacci(num: Int): BigInt = {
    if (num == 0) {
      return 0
    }

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
      //println(s"#1 cache for fib(${num}) = ${fib1}")
    } else {
      fib1 = fibonacci(num - 1)
      cache += num - 1 -> fib1
    }

    if (cache.contains(num - 2)) {
      val n2 = num - 2
      fib2 = cache.get(num - 2).get
      //println(s"#2 for ${num} from cache,  fib(${n2}) = ${fib2}")
    } else {
      fib2 = fibonacci(num - 2)
      cache += num - 2 -> fib2
    }

    cache += num -> (fib1 + fib2)
    //println(s"fib=${fib1}+${fib2}")
    fib1 + fib2

  }
}

