package hashTable

/**
  * Created by prayagupd
  * on 1/21/18
  *
  * facebook 2010, https://www.glassdoor.com/Interview/Write-a-function-that-takes-in-a-roman-numeral-string-and-returns-its-decimal-value-You-may-assume-input-is-a-valid-roman-QTN_56312.htm
  * facebook 2012, https://www.careercup.com/question?id=14959819
  * https://leetcode.com/problems/roman-to-integer/description/
  */

object RomanToDecimal {

  private val romanToInteger = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000)

  /**
    *
    * complexity is O(n) as its sequential iteration.
    */
  def romanToIntegerRecursive(roman: String): Long = toInteger(roman, 0, 0)

  private def toInteger(roman: String, index: Int, value: Long): Long = {

    if (index == roman.length - 1)
      value + romanToInteger(roman(index))

    else if (romanToInteger(roman(index)) < romanToInteger(roman(index + 1)))
      toInteger(roman, index + 1, value - romanToInteger(roman(index)))

    else
      toInteger(roman, index + 1, value + romanToInteger(roman(index)))
  }

  def romanToIntegerIterative(roman: String): Long = {
    var sum = 0

    for (i <- 0 to roman.length - 1) {
      if (i == roman.length - 1)
        sum = sum + romanToInteger(roman(i))

      else if (romanToInteger(roman(i)) < romanToInteger(roman(i + 1)))
        sum = sum - romanToInteger(roman(i))

      else
        sum = sum + romanToInteger(roman(i))
    }

    sum
  }
}
