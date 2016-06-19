package threads

import java.util.Date

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 5/21/16.
 */

class PackagesShippingSchedulerSpec extends FunSuite {

  test("given 6 packages to ship in database, should ship all packages") {

    //given:
    val scheduler = new PackagesShippingScheduler()

    //when:
    scheduler.shipPackages()
    Thread.sleep(2000)

    //then:
    val actualShipped = scheduler.packagesShippedState

    assert(actualShipped.size == 6)

    assert(actualShipped.head.head._1 == "package1")
    assert(actualShipped.head.head._2.isInstanceOf[Date])
    assert(actualShipped(1).head._1 == "package2")
    assert(actualShipped(2).head._1 == "package3")
    assert(actualShipped(3).head._1 == "package4")
    assert(actualShipped(4).head._1 == "package5")
    assert(actualShipped.last.head._1 == "package6")
  }
}
