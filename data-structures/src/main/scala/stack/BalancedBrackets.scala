package stack

/**
  *
  * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
  *
  * https://www.hackerrank.com/challenges/ctci-balanced-brackets
  *
  * https://leetcode.com/problems/valid-parentheses/description/
  *
  * Booking.com, PCLN - https://www.glassdoor.com/Interview/Booking-com-Software-Developer-Interview-Questions-EI_IE256653.0,11_KO12,30.htm
  */

object BalancedBrackets {

  def isBalanced(expression: String): Boolean = {

    import scala.collection.mutable

    val openBraces = new mutable.Stack[Char]()

    val braces = mutable.Map(
      '(' -> ')',
      '{' -> '}',
      '[' -> ']')

    var notBalanced = false

    for (index <- 0 until expression.length if !notBalanced) {

      val char = expression.charAt(index)

      //constraints
      if (!braces.keys.toList.contains(char) && !braces.values.toList.contains(char))
        notBalanced = true

      if (braces.keys.toList.contains(char)) {
        openBraces.push(char)
      }

      if (braces.values.toList.contains(char)) {
        if (openBraces.isEmpty || braces(openBraces.pop()) != char) notBalanced = true
      }

    }

    val balanced = !notBalanced
    balanced && openBraces.isEmpty
  }

}
