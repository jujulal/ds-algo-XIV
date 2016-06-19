package functionalProg.composition

import java.util.Date

import scala.util.Random

case class ContainerState(id: String)
case class WeightedContainerState(id: String, weight: Int)
case class ShippedContainerState(id: String, weight: Int, released: Date)

class ShippingService {
  private def weight(container: ContainerState): WeightedContainerState = {
      val weight = Random.nextInt()
      println(s"Container is weighted $weight")
      new WeightedContainerState(container.id, weight)
  }

  private def shipIt(container: WeightedContainerState) : ShippedContainerState = {
      println(s"Shipping ${container.weight}")
      ShippedContainerState(container.id, container.weight, new Date())
  }

  def release(container: ContainerState): ShippedContainerState = {
    shipIt(weight(container))
  }
}

class ShipItFunctionally {
  
  private def weight(container: ContainerState) = {
    WeightedContainerState(container.id, Random.nextInt())
  }

  private def ship(container: WeightedContainerState) = {
    ShippedContainerState(container.id, container.weight, new Date())
  }

  val release = weight _ andThen ship _

}

class ShipItEvenMoreFunctionally {

  object weight extends Function[ContainerState, WeightedContainerState] {
    override def apply (container: ContainerState) : WeightedContainerState= {
      new WeightedContainerState(container.id, Random.nextInt())
    }
  }

  object ship extends (WeightedContainerState => ShippedContainerState) {
    override def apply (container: WeightedContainerState) : ShippedContainerState = {
      ShippedContainerState(container.id, container.weight, new Date())
    }
  }

  private def w (container: ContainerState) = {
    new WeightedContainerState(container.id, Random.nextInt())
  }

  private def s (container: WeightedContainerState) = {
    new ShippedContainerState(container.id, container.weight, new Date())
  }
  
  val release = w _ andThen s

}
