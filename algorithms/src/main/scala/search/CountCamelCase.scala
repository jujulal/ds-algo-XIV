package search

/**
  * https://www.hackerrank.com/challenges/camelcase/problem
  */

object CountCamelCase {

  def camelCaseCount(data: String): Int = {
    data.collect { case char if char >= 65 && char <= 91 => 1 }.sum
  }
}
