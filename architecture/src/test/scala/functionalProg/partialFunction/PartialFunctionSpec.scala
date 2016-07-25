package functionalProg.partialFunction

import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 1/13/16.
 */

class PartialFunctionSpec extends FlatSpec {

  "partial function" should "divide input number by 100 " in {
    val isHighObject = new PartialFunctionHighPriorityContainer
    assert(isHighObject.highPriorityWeight(200) == 2)
    assert(isHighObject.highPriorityWeight(5) == 0)
  }
}
