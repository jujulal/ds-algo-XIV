package hashTable

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 7/6/16.
 */

class HashTableExperimentSpec extends FunSuite {

  test("shows unique items") {
    val items = HashTableExperiment.itemInventory().iterator.toList
    assert(items.head == "white shirt")
    assert(items(1) == "blue pants")
    assert(items(2) == "blue shirt")
  }
}
