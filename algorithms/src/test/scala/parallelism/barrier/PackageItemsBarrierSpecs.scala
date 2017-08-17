package parallelism.barrier

import org.scalatest.{FunSuite, Matchers}

/**
 * Created by prayagupd
 * on 6/22/16.
 */

class PackageItemsBarrierSpecs extends FunSuite with Matchers {
  test("should wait until all items are arrived at the packing lane") {

    val barrier = new PackageItemsBarrier
    barrier.initiatePacking()

    Thread.sleep(3000)

    assert(barrier.readyToPack)
  }
}
