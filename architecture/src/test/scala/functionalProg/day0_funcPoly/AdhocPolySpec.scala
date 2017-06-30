package functionalProg.day0_funcPoly

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by prayagupd
 * on 1/23/16.
 */

class AdhocPolySpec extends FlatSpec with Matchers {

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
    add(List("prayag", "upd")) shouldBe "-prayag-upd"
  }

  "ad hoc poly" should "doStuff defined in append method of anonymous monoid" in {

    val multiplyMonoid: AppendableMonoid[Int] = new AppendableMonoid[Int] {
      def append(a: Int, b: Int): Int = a * b
      def zero: Int = 1
    }

    add(List(1, 2, 3, 4)) shouldBe 10
    add(List(1, 2, 3, 4))(multiplyMonoid) shouldBe 24
  }
}
