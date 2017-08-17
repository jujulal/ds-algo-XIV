package DP

import DP.Fibonacci.fibonacci
import org.scalatest.{FunSuite, Matchers}

class FibonacciSpecs extends FunSuite with Matchers {

  test("calculates fib") {
    val input = 3

    val startTime: Long = System.currentTimeMillis()

    val fib = fibonacci(input)

    val endTime: Long = System.currentTimeMillis()
    val time = (endTime - startTime) / 1000
    println(s"Time taken for ${fib} = ${time} seconds")

    fib shouldBe 2

    //30 832040
    //40 102334155
    //45 1134903170 //29secs
    //48 4807526976
    //49 7778742049
    //fib(50) = 12586269025
  }
}
