package functionalProg.day0_funcPoly

import org.scalatest.{FunSuite, FlatSpec}

/**
 * Created by prayagupd
 * on 1/19/16.
 */

class CovarienceStackSpec extends FunSuite {

  test("does stuff") {
    var stack: CovarientStack[Any] = new CovarientStack().push("dreams")
    stack = stack.push(new Object())
    stack = stack.push(28)
    
    Console.println(stack)
  }
}
