package stack

import stack.StackWithArrayImpl
import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 5/22/16.
 */

class StackWithArrayImplSpec extends FlatSpec {
  "push" should "add value" in {
    val stack = new StackWithArrayImpl()

    stack.push("order-package-001")

    assert(stack.array.size == 1)
    assert(stack.array.head == "order-package-001")
  }

  "pop" should "remove and return the top value" in {
    val stack = new StackWithArrayImpl()

    stack.push("order-package-001")
    stack.push("order-package-002")

    assert(stack.pop() == "order-package-002")
  }

  "clear" should "remove all elements from the stack" in {
    val stack = new StackWithArrayImpl

    stack.push("order-package-001")
    stack.push("order-package-002")

    stack.clear()

    assert(stack.array.isEmpty)
  }
}
