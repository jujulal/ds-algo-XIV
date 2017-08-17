package DP

import DP.FibonacciSeries.fibonacci
import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer
import scala.math.{BigDecimal, pow}

class FibonacciSeriesSpecs extends FunSuite {

  test("fib series") {
    val tests = 5

    var inputBuffer = Array(1, 2, 4, 5)

    inputBuffer.foreach { input =>
      val startTime: Long = System.currentTimeMillis()
      val fib = fibonacci(input)
      val pow_ = pow(10, 8) + 7.0

      val divider: BigDecimal = pow_
      val numerator = BigDecimal(fib + "")
      val div = numerator % divider

      val endTime: Long = System.currentTimeMillis()
      val time = (endTime - startTime) / 1000
      println(s"${div}")
    }

  }
}
