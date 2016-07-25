package functionalProg.composition

import functionalProg.composition._

/**
 * Created by prayagupd
 * on 1/12/16
 */

object ShipItSpec {
  def main(args: Array[String]) {
    //closureRelease()
    //println(functionalDecompositionRelease())
    println(shipFunctionally())
  }

  /**
   * https://twitter.github.io/scala_school/pattern-matching-and-functional-composition.html
   * @return
   */
  def functionalDecompositionRelease(): ShippedContainerState = {
    val shipIt = new ShipItFunctionally
    shipIt.release(new ContainerState("Pizza-shirt"))
  }

  def closureRelease(): Unit = {
    val shippingService = new ShippingService
    val result = shippingService.release(new ContainerState("ILP1001"))
    println(result)
  }

  def shipFunctionally(): ShippedContainerState = {
    val s = new ShipItEvenMoreFunctionally
    s.release(new ContainerState("Dreams"))
  }
}
