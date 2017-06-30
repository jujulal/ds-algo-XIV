package functionalProg.day0_funcPoly

/**
 *
 * The annotation [+T] declares type [T] to be used only in covariant positions.
 *
 * Similarly, [-T] would declare [T] to be used only in contravariant positions.
 *
 * For covariant type parameters we get a covariant subtype relationship regarding this type parameter.
 *
 * For our example this means CovarientStack[T] is a subtype of CovarientStack[S] if [T] is a subtype of [S].
 *
 * The opposite holds for type parameters that are tagged with a -.
 *
 * @reference http://docs.scala-lang.org/tutorials/tour/variances.html
 */

class CovarientStack[+A] {

  def top: A = error("no element on stack")

  def pop: CovarientStack[A] = error("no element on stack")

  override
  def toString() = ""

  // What's the difference between  S < : T and [+T] in Scala?
  // http://stackoverflow.com/a/4531696/432903
  // Q[S <: T] means that class Q can take any class [S] that is a subclass of [T].

  // What's the difference between A <: B and +B in Scala?
  // http://stackoverflow.com/a/22080498/432903

  def push[B >: A](elem: B): CovarientStack[B] = {
    new CovarientStack[B] {

      override
      def top: B = elem

      override
      def pop: CovarientStack[B] = CovarientStack.this

      override
      def toString() = elem.toString() + " " +
        CovarientStack.this.toString()
    }
  }
}
