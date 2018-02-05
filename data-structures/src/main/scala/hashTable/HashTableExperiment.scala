package hashTable

import java.util.Date

/**
 * Created by prayagupd
 * on 1/2/16.
 */

object HashTableExperiment {

  val retailPackages = Map(
    "package1" -> Map(
      "items" -> List("white shirt", "blue pants", "blue shirt"),
      "shippingDate" -> new Date(2016, 10, 28)
    ),
    "package2" -> Map(
      "items" -> List("blue shirt", "brown pants", "blue converse"),
      "shippingDate" -> new Date(2016, 11, 23)
    )
  )

  def itemInventory(): Iterable[String] = {
    retailPackages map { _._2 } map { _("items").asInstanceOf[List[String]] } flatten
  }
}
