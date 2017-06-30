package functionalProg.day1_typesclasses

import org.scalatest.{FlatSpec, Matchers}

import scalaz._

/**
  * lession - http://eed3si9n.com/learning-scalaz/Equal.html
  *
  * Created by prayagupd
  * on 1/26/16.
  */

class TypeClassesSpec extends FlatSpec with Matchers {

  //http://eed3si9n.com/learning-scalaz/Order.html
  "typeclass" should "check equality" in {

    1 === "foo" shouldBe false

    import scalaz.Ordering.LT
    import scalaz.Scalaz._

    1.0 gt 2.0 shouldBe false
    (1 ?|? 2) shouldBe LT
    1.some =/= 2.some
    1.0 max 2.0 shouldBe 2.0
  }

  "Order typeclass" should "check the order" in {

    1 > 2.0 shouldBe false
  }

  //http://stackoverflow.com/a/30946172/432903
  "scalaz typeclass Show.shows" should "return string" in {

    //3.show
    //3.shows
    //"this looks cool".println

    trait ShippingContainer
    case object Singles extends ShippingContainer
    case object Multis extends ShippingContainer

    implicit val ShippingContainerShows: Show[ShippingContainer] = Show.shows {
      case Singles => "Singles"
      case Multis => "Multis"
    }

    def shipIt[A: Show](container: A): String = implicitly[Show[A]].shows(container)

    val singles: ShippingContainer = Singles

    shipIt(singles) shouldBe "Singles"

  }

  //http://eed3si9n.com/learning-scalaz/Read.html
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

    Read[Double].read("10") shouldBe 10.0 //if implicit Read[Double] is not defined throws error
    Read[Int].read("28") shouldBe 28
    // assert(Read[Float].read("28.2") == 28.2) //throws exception
  }

  "Equals typeclass" should "do something" in {

    case class Event(name: String)

    val ContainerShipped = Event("ContainerShip")
    val ContainerWeighted = Event("ContainerWeighted")
    val ContainerPicked = Event("ContainerPicked")

    implicit val EventEqual: Equal[Event] = Equal.equal(_ == _)
    //ContainerShipped === ContainerWeighted
  }

  //http://eed3si9n.com/learning-scalaz/Enum.html
  "Enums" should "be enums" in {

    'a' to 'e' //shouldBe NumericRange('a', 'e', 1)
    //'a' |-> 'e'
    //3 |=> 5

    //'B'.succ
  }

  //http://eed3si9n.com/learning-scalaz/Bounded.html
  "Bounded" should "Bound" in {
    //implicitly[scalaz.Enum[Double]].max
    //implicitly[scalaz.Enum[Char]].min shouldBe Some
    //implicitly[Enum[Int]].min
  }

  "typeclasses 102" should "typeclass" in {

    case class TrafficLight(name: String)
    val red = TrafficLight("red")
    val yellow = TrafficLight("yellow")
    val green = TrafficLight("green")

    implicit val TrafficLightEqual: Equal[TrafficLight] = Equal.equal(_ == _)

    red === yellow shouldBe false

  }

  //http://eed3si9n.com/learning-scalaz/a+Yes-No+typeclass.html
  "Truthy typeclass(looks like trait)" should "Y/N" in {

    trait CanTruthy[A] { self =>
      def truthys(a: A): Boolean
    }

    object CanTruthy {
      def apply[A](implicit ev: CanTruthy[A]): CanTruthy[A] = ev
      def truthys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
        def truthys(a: A): Boolean = f(a)
      }
    }

    trait CanTruthyOps[A] {
      def self: A
      implicit def F: CanTruthy[A]
      final def truthy: Boolean = F.truthys(self)
    }

    object ToCanIsTruthyOps {
      implicit def toCanIsTruthyOps[A](v: A)(implicit ev: CanTruthy[A]) =
        new CanTruthyOps[A] {
          def self = v
          implicit def F: CanTruthy[A] = ev
        }
    }

    implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys({
      case 0 => false
      case _ => true
    })

    //10.truthy shouldBe true
  }

  //http://eed3si9n.com/learning-scalaz/Functor.html
  //https://tpolecat.github.io/2014/03/21/functor.html
  //A Functor is something you can map over.
  "Functor typeclass" should "be able to mapped over by fns" in {
    List(1, 2, 3) map {_ + 1} shouldBe List(2,3,4)

    import scalaz._
    import std.list._ // type class instances for List
    import syntax.bind._ // syntax for the Bind type class (and its parents)

    //(1, 2, 3) map {_ + 1} shouldBe (1, 2, 4)

    //    val res = ((x: Int) => x + 1) map {_ * 7}
    //    assert(res(30) === 28)

    //    assert((((_: Int) * 3) map {_ + 100}) (1) === 103)

    List(1, 2, 3) map {3*} shouldBe List(3, 6, 9)

    //Functor[List].lift {(_: Int) * 2}(List(2)) shouldBe 4

    List(1, 2, 3) >| 8 shouldBe List(8, 8, 8)
    List(1, 2, 3) >| "w" shouldBe List("w", "w", "w")
    List(1, 2, 3) as "y" shouldBe List("y", "y", "y")
    List(1, 2, 3).fpair shouldBe List((1, 1), (2, 2), (3, 3))
    List(1, 2, 3).void shouldBe List((), (), ())

    List(List(1, 2)).join shouldBe List(1, 2)
  }

}
