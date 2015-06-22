package zazz

import collection.mutable.Stack
import org.scalatest._

class HeapSortSpec extends FlatSpec {

  "array" should "be heap sorted" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }
}
