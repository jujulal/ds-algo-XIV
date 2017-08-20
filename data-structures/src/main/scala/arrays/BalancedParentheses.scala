package arrays

/**
  * https://www.hackerrank.com/challenges/ctci-balanced-brackets
  */

object BalancedParentheses {

  def isBalanced(data: String): Boolean = {

    var lastClosedIndex = 0

    var notBalanced = false

    var openCount = 0
    var closeCount = 0

    for (iterator <- 0 until data.length; if !notBalanced) {

      if (data.charAt(iterator) == '(') {
        openCount = openCount + 1
        if (lastClosedIndex == 0) lastClosedIndex = iterator + 1

        var found = false

        for (closedSearchIndex <- lastClosedIndex until data.length; if !found) {
          if (data.charAt(closedSearchIndex) == ')') {
            lastClosedIndex = closedSearchIndex
            found = true
          }
        }
        if (!found) {
          notBalanced = true
        }
      } else if (data.charAt(iterator) == ')'){
        closeCount = closeCount + 1
      }
    }

    !notBalanced && (openCount == closeCount)
  }
}
