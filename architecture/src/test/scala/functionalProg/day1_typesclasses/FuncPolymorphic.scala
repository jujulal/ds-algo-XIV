package functionalProg.day1_typesclasses

import org.scalatest.{FunSuite, Matchers}

/**
  * SEA
  * Created by prayagupd
  * on 6/29/17.
  */

class FuncPolymorphic extends FunSuite with Matchers {

  test("Non generic method that needs to defined each time for new Type") {

    def sumInt(xs: List[Int]): Int = xs.foldLeft(0) {
      _ + _
    }
    def sumFloat(xs: List[Float]): Float = xs.foldLeft(0f) {
      _ + _
    }

    sumInt(List(1, 2, 3)) shouldBe 6
    sumFloat(List(1f, 2f, 3f)) shouldBe 6f
  }

  test("generalised using Monoid Structure that applies on Int") {

    //monoid
    object Int32MonoidStructure {
      def append(x: Int, y: Int): Int = x + y

      def zero: Int = 0
    }

    object Float64MonoidStructure {
      def append(x: Float, y: Float): Float = x + y

      def zero: Float = 0f
    }

    def sumInt(xs: List[Int]): Int = xs.foldLeft(Int32MonoidStructure.zero) {
      Int32MonoidStructure.append(_, _)
    }
    def sumFloat(xs: List[Float]): Float = xs.foldLeft(Float64MonoidStructure.zero) {
      Float64MonoidStructure.append(_, _)
    }

    sumInt(List(1, 2, 3)) shouldBe 6
    sumFloat(List(1f, 10f, 20.5f)) shouldBe 31.5f
  }

  test("very generalised Monoid Structure that applies on everything even on president of US, lets start with Int Monoid structure") {

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    object Int32MonoidStructure extends MonoidStructure[Int] {

      override def append(x: Int, y: Int): Int = x + y

      override def zero: Int = 0
    }

    def sum(xs: List[Int], monoidStructure: MonoidStructure[Int]): Int = xs.foldLeft(monoidStructure.zero) {
      monoidStructure.append(_, _)
    }

    sum(List(10, 20, 30), Int32MonoidStructure) shouldBe 60

  }

  test("very generalised Monoid Structure that applies on everything even on president of US") {

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    object Int32MonoidStructure extends MonoidStructure[Int] {

      override def append(x: Int, y: Int): Int = x + y

      override def zero: Int = 0
    }


    def sum[T](xs: List[T], monoidStructure: MonoidStructure[T]): T = xs.foldLeft(monoidStructure.zero) {
      monoidStructure.append(_, _)
    }

    //usage
    sum(List(10, 20, 30), Int32MonoidStructure) shouldBe 60

    //also
    object Float64MonoidStructure extends MonoidStructure[Float] {

      override def append(x: Float, y: Float): Float = x + y

      override def zero: Float = 0f
    }

    sum(List(1f, 2f, 3f), Float64MonoidStructure) shouldBe 6f
  }

  test("Almost there, now lets make the MonoidStructure to be implicit so the don't have to passed on sum method, and looks natural") {

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    object Int32MonoidStructure extends MonoidStructure[Int] {

      override def append(x: Int, y: Int): Int = x + y

      override def zero: Int = 0
    }

    def sum[T](xs: List[T])(implicit monoidStructure: MonoidStructure[T]): T = xs.foldLeft(monoidStructure.zero) {
      monoidStructure.append(_, _)
    }

    //usage
    implicit val int32MonoidStructure = Int32MonoidStructure
    sum(List(10, 20, 30)) shouldBe 60

    //also for another MonoidStructure
    object Float64MonoidStructure extends MonoidStructure[Float] {

      override def append(x: Float, y: Float): Float = x + y

      override def zero: Float = 0f
    }

    implicit val float64MonoidStructure = Float64MonoidStructure
    sum(List(1f, 2f, 3f)) shouldBe 6f
  }

  test("not done yet, because in above example I still have to define implicit val that I want, why not make sum to figure it out implicitly") {

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    implicit val int32MonoidStructure = new MonoidStructure[Int] {

      override def append(x: Int, y: Int): Int = x + y

      override def zero: Int = 0
    }

    def sum[T: MonoidStructure](xs: List[T]): T = {
      val monoidStructure = implicitly[MonoidStructure[T]]
      xs.foldLeft(monoidStructure.zero) {
        monoidStructure.append(_, _)
      }
    }

    //usage
    sum(List(10, 20, 30)) shouldBe 60

    //also for another MonoidStructure
    implicit val float64MonoidStructure = new MonoidStructure[Float] {

      override def append(x: Float, y: Float): Float = x + y

      override def zero: Float = 0f
    }

    sum(List(1f, 2f, 3f)) shouldBe 6f
  }

  test("what if I want different Monoid structure than the implicit one?") {

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    implicit val int32MonoidStructure = new MonoidStructure[Int] {

      override def append(x: Int, y: Int): Int = x + y

      override def zero: Int = 0
    }

    def sum[T: MonoidStructure](xs: List[T]): T = {
      val monoidStructure = implicitly[MonoidStructure[T]]
      xs.foldLeft(monoidStructure.zero) {
        monoidStructure.append(_, _)
      }
    }

    //usage
    sum(List(10, 20, 30)) shouldBe 60

    //different monoid
    val incrementSumBy1Monoid = new MonoidStructure[Int] {
      override def append(x: Int, y: Int): Int = x + y + 1

      override def zero: Int = 0
    }

    sum(List(1, 2, 3))(incrementSumBy1Monoid) shouldBe 6 + (3 * 1)
  }

  test("Thought I was done, not yet. Lets define our own FoldLeft") {

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    object UDFoldLeftList {
      def foldL[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b) {
        f
      }
    }

    def sum[M: MonoidStructure](xs: List[M]): M = {
      val monoidStructure = implicitly[MonoidStructure[M]]
      UDFoldLeftList.foldL(xs, monoidStructure.zero, monoidStructure.append)
    }

    implicit val defaultIntMonoidStructure = new MonoidStructure[Int] {
      override def zero: Int = 0

      override def append(x: Int, y: Int): Int = x + y
    }

    //usage
    sum(List(1, 2, 3)) shouldBe 6
  }

  test("foldL with typeclasses") {

    trait FoldLeft[F[_]] {
      def foldL[A, B](xs: F[A], b: B, f: (B, A) => B): B
    }

    object FoldLeft {
      implicit val FoldLeftList = new FoldLeft[List] {
        override def foldL[A, B](xs: List[A], b: B, f: (B, A) => B): B = xs.foldLeft(b) {
          f
        }
      }
    }

    trait MonoidStructure[T] {
      def append(x: T, y: T): T

      def zero: T
    }

    def sum[M[_] : FoldLeft, A: MonoidStructure](xs: M[A]): A = {
      val monoidStructure = implicitly[MonoidStructure[A]]
      val function = implicitly[FoldLeft[M]]

      function.foldL(xs, monoidStructure.zero, monoidStructure.append)
    }

    //usage
    implicit val int32MoniodStructure = new MonoidStructure[Int] {
      override def zero: Int = 0

      override def append(x: Int, y: Int): Int = x + y
    }

    sum(List(1, 2, 10)) shouldBe 13
  }

}
