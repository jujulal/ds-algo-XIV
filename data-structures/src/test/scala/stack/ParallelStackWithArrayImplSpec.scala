package stack

import stack.{ParallelStackWithArrayImpl, StackWithArrayImpl}
import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 5/22/16.
 */

class ParallelStackWithArrayImplSpec extends FlatSpec {
  "push" should "add value" in {
    val stack = new ParallelStackWithArrayImpl()

    new Thread(new Runnable {
      override def run(): Unit = {
        Range(1,20).foreach { case(index) =>
          stack.push(s"package-$index")
        }
      }
    }).start()

    new Thread(new Runnable {
      override def run(): Unit = {
        Range(1,10).foreach { case(index) =>
          stack.pop()
        }
      }
    }).start()

    //how to test this
    Thread.sleep(10000)
    assert(stack.array.length > 10)
  }

}
