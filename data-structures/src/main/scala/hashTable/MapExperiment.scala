package hashTable

import java.util.Date

/**
 * Created by prayagupd
 * on 1/2/16.
 */

object MapExperiment {

  def mapExp(): Unit = {
    val packages = Map(
      "package1" -> Map(
        "items" -> Array("white shirt", "blue pants"),
        "shippingDate" -> new Date(2016, 10, 28)
    ),
      "package2" -> Map(
          "items" -> Array("blue shirt", "brown pants"),
          "shippingDate" -> new Date(2016, 11, 23)
        )
    )

    val items = packages.map { case(k, v) =>
        v.values
    } .map { case (element) =>
        element
    }

    println(items)
  }
}

object Maps {

  def main(args: Array[String]) {
    MapExperiment.mapExp()
  }
}
