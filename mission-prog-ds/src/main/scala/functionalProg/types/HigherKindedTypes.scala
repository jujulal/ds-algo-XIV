package functionalProg.types

/**
 * Created by prayagupd
 * on 1/21/16.
 */

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