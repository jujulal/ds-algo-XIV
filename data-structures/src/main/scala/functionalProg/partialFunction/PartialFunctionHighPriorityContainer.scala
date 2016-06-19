package functionalProg.partialFunction

/**
 * http://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html
 *
 * Created by prayagupd
 * on 1/13/16.
 */

class PartialFunctionHighPriorityContainer {

  val highPriorityWeight = new PartialFunction[Int, Int] {
    def apply(weight: Int) = weight / 100
    def isDefinedAt(weight: Int) = weight != 0
  }
}
