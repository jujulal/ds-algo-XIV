package functionalProg.day0_funcPoly

import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 1/21/16.
 */

class HigherKindedTypesSpec extends FlatSpec {

  // HigherKindedContainer is polymorphic in a parameterized type (M[_])
  trait HigherKindedContainer[M[_]] {
    def put[A](x: A): M[A];
    def get[A](m: M[A]): A
  }

  class HigherKindedTypes {
    val container = new HigherKindedContainer[List] {
      def put[A](x: A) = List(x);
      def get[A](m: List[A]) = m.head
    }
  }

  "put" should "return a list" in {
    val container = new HigherKindedContainer[List] {
      def put[A](x: A) = List(x);
      def get[A](m: List[A]) = m.head
    }
    assert(container.put("dream-in-march-OH") == List("dream-in-march-OH"))
  }
}
