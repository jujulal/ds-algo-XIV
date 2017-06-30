package functionalProg.day0_funcPoly

/**
 * Created by prayagupd
 * on 1/23/16.
 */

trait Appendable[A] {
  def append(a1: A, a2: A): A
}

// http://eed3si9n.com/learning-scalaz/sum+function.html
trait AppendableMonoid[A] {
  def append(a1: A, a2: A): A
  def zero: A
}
