package threads

import scala.collection.mutable.ListBuffer

/**
 * Created by prayagupd
 * on 5/21/16.
 */

object Database {

  val packagesState = Array(Map("package1" -> "Columbus, OH"),
    Map("package2" -> "Seattle, WA"),
    Map("package3" -> "New York, NY"),
    Map("package4" -> "San Francisco, CA"),
    Map("package5" -> "San Diego, CA"),
    Map("package6" -> "Los Angeles, CA"))


  val packagesList = ListBuffer(Map("shippingAddress" -> "Columbus, OH"),
    Map("shippingAddress" -> "Seattle, WA"),
    Map("shippingAddress" -> "New York, NY"),
    Map("shippingAddress" -> "San Francisco, CA"),
    Map("shippingAddress" -> "San Diego, CA"),
    Map("shippingAddress" -> "Los Angeles, CA"))

}
