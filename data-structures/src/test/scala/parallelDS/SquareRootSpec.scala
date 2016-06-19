package parallelDS

import scala.collection.mutable.ArrayBuffer

/**
 * Created by prayagupd
 * on 5/22/16.
 */

object SquareRootSpec {

  def squareRoot (): Unit = {
    val items = Range(1, 100)
    val squareRoot = new ArrayBuffer[Int]()

    Range(1, 100).foreach { case (index) =>
      squareRoot+=0
    }

    items.toParArray.zipWithIndex.foreach { case (element, index) =>
      println(s"squaring $element")
      squareRoot(index) = element * element
    }
  }

  def main(args: Array[String]) {
    squareRoot()
  }
}
