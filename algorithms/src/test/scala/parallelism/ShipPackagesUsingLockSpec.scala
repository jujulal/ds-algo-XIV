package parallelism

import org.scalatest.FunSuite
import parallelism.locking.ShipPackagesUsingLock

/**
 * Created by prayagupd
 * on 5/22/16.
 */

class ShipPackagesUsingLockSpec extends FunSuite {

  test("given a list of packages of size 6, " +
    "pushToStackAsync should add package asynchronously to stack and " +
    "popFromStackAsync should pop and add back to list") {

    val ship = new ShipPackagesUsingLock()
    ship.packageList = Database.packagesList

    //op1
    ship.pushToStackAsync()

    Thread.sleep(1000)
    assert(ship.releaseStack.nonEmpty)
    assert(ship.releaseStack.top.head == ("shippingAddress", "Los Angeles, CA"))
    assert(ship.packageList.size == 5)

    //op2
    ship.popFromStackAsync()
    Thread.sleep(1000)

    assert(ship.releaseStack.isEmpty)
    assert(ship.packageList.size == 6)
  }
}
