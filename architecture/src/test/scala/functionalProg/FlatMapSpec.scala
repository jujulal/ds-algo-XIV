package functionalProg

import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 1/23/16.
 */

class FlatMapSpec extends FlatSpec {
  "flat map" should "flat map" in {
    println(FlatMap.flatMapCharCombinations())
  }

  "flat map yield" should "flat map" in {
    println(FlatMap.flatMapCharCombinationsYield())
  }
}
