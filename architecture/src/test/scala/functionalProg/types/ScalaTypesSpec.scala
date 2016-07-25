package functionalProg.types

/**
 * Created by prayagupd
 * on 1/20/16.
 */

object ScalaTypesSpec {

  def main(args: Array[String]) {

    implicit def strToInt(anyString: String) = anyString.toInt

    println(new Container[Int].weight(28))

    println(new Container[String].weight("28"))

    println(new ContainerEqualsTo(10).weight)

    println(List(1, 2).sum)

//    println(List("whoop").sum)

//    println(new ContainerViewable("10").weight)
  }

}
