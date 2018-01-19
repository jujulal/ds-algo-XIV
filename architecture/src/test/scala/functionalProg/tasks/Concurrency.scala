package functionalProg.tasks

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions

object Concurrency {

  def main(args: Array[String]): Unit = {

    //sequentialTasks()

    quickTask2()

    Thread.sleep(30000)
  }

  private def quickTask2() = {
    for {
      x <- Future {
        100
      }
    } yield {
      println(x)
      x
    }
  }

  private def sequentialTasks() = {

    def pick(item: String) = Future {
      println(s"picking $item\n")
      (1 to 100).foreach(x => println("pick - " + item))
      Thread.sleep(5000)
      s"$item picked-up"
    }

    def pack(item: String) = Future {
      println(s"packing $item\n")
      (1 to 100).foreach(x => println("pack - " + item))
      Thread.sleep(5000)
      s"$item packed"
    }

    for {
      pick1 <- pick("item1")
      pick2 <- pick("item2")
      pack1 <- pack("###1")
      pack2 <- pack("###2")
    } yield {
      println("packing and packing done")
      pick1 + " - " + pick2
    }
  }

  def weight(): Future[Int] = {

    val data = for {
      x <- Future(100)
      y <- Future(200)
    } yield {

      for {
        a <- Future(x * 1)
        b <- Future(y * 2)
      } yield a * b
    }

    data.flatten

    data.flatten
  }
}
