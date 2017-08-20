package arrays

import org.scalatest.{FunSuite, Matchers}

class BalancedParenthesesSpecs extends FunSuite with Matchers {

  test("checks if parenthesis are balanced") {
    BalancedParentheses.isBalanced("()") shouldBe true
  }

  test("checks if parenthesis are balanced 2") {
    BalancedParentheses.isBalanced("(1)") shouldBe true
    BalancedParentheses.isBalanced("((apple))") shouldBe true

    BalancedParentheses.isBalanced("(") shouldBe false
    BalancedParentheses.isBalanced(")") shouldBe false
    BalancedParentheses.isBalanced(")[(]") shouldBe false
  }
}
