package functionalProg.partialFunction

import org.scalatest.{FlatSpec, Matchers}

/**
  * http://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html
 * Created by prayagupd
 * on 1/13/16.
 */

class PartialFunctionSpec extends FlatSpec with Matchers {


  class PartialFunctionHighPriorityContainer {

    val highPriorityWeight = new PartialFunction[Int, Int] {
      def apply(weight: Int) = weight / 100
      def isDefinedAt(weight: Int) = weight != 0
    }
  }

  "partial function" should "divide input number by 100" in {
    val isHighObject = new PartialFunctionHighPriorityContainer

    isHighObject.highPriorityWeight.apply(200) shouldBe 2
    isHighObject.highPriorityWeight(200) shouldBe 2

    isHighObject.highPriorityWeight.apply(5) shouldBe 0
    isHighObject.highPriorityWeight(5) shouldBe 0

  }

}
