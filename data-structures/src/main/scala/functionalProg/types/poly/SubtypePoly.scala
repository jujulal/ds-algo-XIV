package functionalProg.types.poly

/**
 * Created by prayagupd
 * on 1/23/16.
 */

trait Plusable[A] {
  def plus(a2: A): A
}

class MyInteger extends Plusable[Int] {
  override def plus(a2: Int): Int = 2 + a2
}

object SubtypePoly {
  def plusWhatever[A <: Plusable[A]](value1: A, value2: A): A =
    value1.plus(value2)
}
