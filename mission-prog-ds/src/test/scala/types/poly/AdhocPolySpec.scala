package types.poly

import functionalProg.types.poly.{AppendableMonoid}
import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 1/23/16.
 */

class AdhocPolySpec extends FlatSpec {

  implicit val IntMonoid: AppendableMonoid[Int] = new AppendableMonoid[Int] {
    def append(a: Int, b: Int): Int = a + b
    def zero: Int = 0
  }

  implicit val StringMonoid: AppendableMonoid[String] = new AppendableMonoid[String] {
    def append(a: String, b: String): String = a +"-"+ b
    def zero: String = ""
  }

  // What is this type A
  // http://stackoverflow.com/q/22934830/432903
  // http://stackoverflow.com/a/2982293/432903
  // [A: AppendableMonoid] is a type parameter with a Context Bound. It's syntactic sugar.
  // def add[A](list: List[A])(implicit val $ev: AppendableMonoid[A]): A
  def add[A: AppendableMonoid](list: List[A]): A = {
    val m = implicitly[AppendableMonoid[A]]
    list.foldLeft(m.zero)(m.append)
  }

  "ad hoc poly" should "add ints" in {
    assert(add(List(1, 2, 3)) == 6)
  }

  "ad hoc poly" should "add string types" in {
    assert(add(List("prayag", "dreams")) == "-prayag-dreams")
  }

  "ad hoc poly" should "doStuff defined in append method of anonymous monoid" in {
    val multiplyMonoid: AppendableMonoid[Int] = new AppendableMonoid[Int] {
      def append(a: Int, b: Int): Int = a * b
      def zero: Int = 1
    }

    assert(add(List(1, 2, 3, 4)) == 10)
    assert(add(List(1, 2, 3, 4))(multiplyMonoid) == 24)
  }
}
