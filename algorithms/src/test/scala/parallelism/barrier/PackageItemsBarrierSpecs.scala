package parallelism.barrier

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 6/22/16.
 */

class PackageItemsBarrierSpecs extends FunSuite {
  test("should wait until all items are arrived at the packing lane") {

    val barrier = new PackageItemsBarrier
    barrier.initiatePacking()

    Thread.sleep(3000)

    assert(barrier.readyToPack)
  }
}
