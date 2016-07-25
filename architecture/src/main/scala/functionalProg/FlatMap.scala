package functionalProg

import scala.collection.immutable.NumericRange
import scala.collection.immutable.Range.Inclusive

/**
 * Created by prayagupd
 * on 1/23/16.
 */

object FlatMap {

  val chars : NumericRange.Inclusive[Char] = 'a' to 'z'

  def flatMapCharCombinations(): IndexedSeq[String] = {

    val perms = chars flatMap { a =>
      chars flatMap { b =>
        if (a != b) Seq("%c%c".format(a, b))
        else Seq()
      }
    }
    perms
  }

  def flatMapCharCombinationsYield (): IndexedSeq[String] = {
    val perms = for {
      a <- chars
      b <- chars
      if a != b
    } yield "%c%c".format(a, b)

    perms
  }
}
