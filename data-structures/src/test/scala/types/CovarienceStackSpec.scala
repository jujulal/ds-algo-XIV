package types

import functionalProg.types.CovarientStack

/**
 * Created by prayagupd
 * on 1/19/16.
 */

object CovarienceStackSpec {

  def main(args: Array[String]) {
    var stack: CovarientStack[Any] = new CovarientStack().push("dreams")
    stack = stack.push(new Object())
    stack = stack.push(28)
    
    Console.println(stack)
  }
}
