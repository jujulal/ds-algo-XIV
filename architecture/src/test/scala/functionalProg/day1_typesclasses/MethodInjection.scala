package functionalProg.day1_typesclasses

import org.scalatest.{FunSuite, Matchers}

/**
  * SEA
  * Created by prayagupd
  * on 6/29/17.
  */

class MethodInjection extends FunSuite with Matchers {

  trait MonoidStructure[T] {
    def append(x: T, y: T): T
    def zero: T
  }

  test("add two numbers usign Monoid structure") {

    def add[A: MonoidStructure](x: A, y: A): A = {
      implicitly[MonoidStructure[A]].append(x, y)
    }

    //usage
    implicit val float64MonidStructure = new MonoidStructure[Float] {
      override def zero: Float = 0f

      override def append(x: Float, y: Float): Float = x + y
    }

    add(10f, 20f) shouldBe 30f
  }

  test("add two numbers with method enrichment for add") {

    trait MonoidOperation[A] {
      val func: MonoidStructure[A]
      val value: A

      def |+|(a2: A) = func.append(value, a2)
    }

    implicit def toMonoidOperation[A: MonoidStructure](a: A): MonoidOperation[A] = new MonoidOperation[A] {
      override val func: MonoidStructure[A] = implicitly[MonoidStructure[A]]
      override val value: A = a
    }

    //(3 |+| 4) shouldBe 7
  }

  test("type syntaxes") {
    import scalaz.syntax._
    import std.option._

    1.some | 2 shouldBe 1

    //((1 > 10)? 1 | 2) shouldBe 2

    if (1 > 10) 1 else 2 shouldBe 2
  }

}
