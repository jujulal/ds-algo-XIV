package hashTable

/**
  * Created by prayagupd
  * on 1/21/18
  *
  * https://leetcode.com/problems/roman-to-integer/description/
  */

object RomanToInteger {

  private val romanToInteger = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )

  def romanToInteger(roman: String): Long = {
    var sum = 0
    roman.zipWithIndex.foreach { case (char, i) =>

      if (i == roman.length - 1)
        sum = sum + romanToInteger(char)

      else if (romanToInteger(char) < romanToInteger(roman(i + 1)))
        sum = sum - romanToInteger(char)

      else
        sum = sum + romanToInteger(char)
    }

    sum
  }
}
