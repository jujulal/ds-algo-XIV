package threads

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 5/22/16.
 */

class ShipPackagesUsingLockSpec extends FunSuite {

  test("given a list of packages of size 6, " +
    "pushToStackAsync should add package asynchronously to stack and " +
    "popFromStackAsync should pop and add back to list") {

    val ship = new ShipPackagesUsingLock()
    ship.list = Database.packagesList

    //op1
    ship.pushToStackAsync()

    Thread.sleep(1000)
    assert(ship.stack.nonEmpty)
    assert(ship.stack.top.head == ("shippingAddress", "Los Angeles, CA"))
    assert(ship.list.size == 5)

    //op2
    ship.popFromStackAsync()
    Thread.sleep(1000)

    assert(ship.stack.isEmpty)
    assert(ship.list.size == 6)
  }
}
