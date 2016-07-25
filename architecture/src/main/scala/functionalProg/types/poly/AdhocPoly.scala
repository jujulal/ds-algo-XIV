package functionalProg.types.poly

/**
 * Created by prayagupd
 * on 1/23/16.
 */

trait Appendable[A] {
  def append(a1: A, a2: A): A
}


class AdhocPoly {
  def appendAny[A: Appendable](a1: A, a2: A): A =
    implicitly[Appendable[A]].append(a1, a2)
}

// http://eed3si9n.com/learning-scalaz/sum+function.html
trait AppendableMonoid[A] {
  def append(a1: A, a2: A): A
  def zero: A
}
