package functionalProg.typesclasses

import org.scalatest.FlatSpec

import scalaz._

/**
 * Created by prayagupd
 * on 1/26/16.
 */

class TypeClassesSpec extends FlatSpec {

  "Order typeclass" should "check the order" in {
    assert((1 > 2.0) == false)
//    assert((1 ?|? 2) == false)
//    assert(1.some =/= 2.some)
  }

  //http://stackoverflow.com/a/30946172/432903
  "scalaz typeclass Show.shows" should "return string" in {
    trait ShippingContainer
    case object Singles extends ShippingContainer
    case object Multis extends ShippingContainer

    implicit val ShippingContainerShows: Show[ShippingContainer] = Show.shows {
      case Singles => "Singles"
      case Multis => "Multis"
    }

    def shipIt[A: Show](container: A): String =
      implicitly[Show[A]].shows(container)

    val singles: ShippingContainer = Singles

    assert(shipIt(singles) == "Singles")

    //3.show
  }

  //https://gist.github.com/josdirksen/9051baf09003dac37386
  "scala typeclass Read(opposite of Show)" should "return the proper type off the string" in {
    trait Read[T] {
      def read(x: String): T
    }

    object Read {
      def apply[A](implicit instance: Read[A]): Read[A] =
        instance
    }

    implicit val ReadDouble = new Read[Double] {
      def read(x: String): Double = {
        x.toDouble
      }
    }

    implicit val ReadInt = new Read[Int] {
      def read(x: String): Int = {
        x.toInt
      }
    }

    assert(Read[Double].read("10") == 10.0) //if implicit Read[Double] is not defined throws error
    assert(Read[Int].read("28") == 28)
    // assert(Read[Float].read("28.2") == 28.2) //throws exception
  }

  "Equals typeclass" should "do something" in {

    case class Event(name: String)
    val ContainerShipped = Event("ContainerShip")
    val ContainerWeighted = Event("ContainerWeighted")
    val ContainerPicked = Event("ContainerPicked")
    implicit val EventEqual: Equal[Event] = Equal.equal(_ == _)
//    ContainerShipped === ContainerWeighted
  }

  "Functor" should "" in {
//    assert((1, 2, 3) map {_ + 1} === (1,2,4))

//    val res = ((x: Int) => x + 1) map {_ * 7}
//    assert(res(30) === 28)


//    assert((((_: Int) * 3) map {_ + 100}) (1) === 103)
  }

}
