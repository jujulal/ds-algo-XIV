package types

import functionalProg.types.HigherKindedContainer
import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 1/21/16.
 */

class HigherKindedTypesSpec extends FlatSpec {
  "put" should "return a list" in {
    val container = new HigherKindedContainer[List] {
      def put[A](x: A) = List(x);
      def get[A](m: List[A]) = m.head
    }
    assert(container.put("dream-in-march") == List("dream-in-march"))
  }
}
