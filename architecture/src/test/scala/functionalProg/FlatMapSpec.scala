package functionalProg

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.NumericRange

/**
 * Created by prayagupd
 * on 1/23/16.
 */

class FlatMapSpec extends FlatSpec with Matchers {

  "flat map" should "flat map chars" in {
    CustomFlatMap.flatMapCharCombinations('a' to 'd') shouldBe
      Vector("ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap", "aq", "ar", "as", "at", "au", "av", "aw", "ax", "ay", "az",
        "ba", "bc", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bk", "bl", "bm", "bn", "bo", "bp", "bq", "br", "bs", "bt", "bu", "bv", "bw", "bx", "by", "bz",
        "ca", "cb", "cd", "ce", "cf", "cg", "ch", "ci", "cj", "ck", "cl", "cm", "cn", "co", "cp", "cq", "cr", "cs", "ct", "cu", "cv", "cw", "cx", "cy", "cz",
        "da", "db", "dc", "de", "df", "dg", "dh", "di", "dj", "dk", "dl", "dm", "dn", "do", "dp", "dq", "dr", "ds", "dt", "du", "dv", "dw", "dx", "dy", "dz")
  }

  "flat map yield" should "flat map" in {
    CustomFlatMap.flatMapCharCombinationsYield('a' to 'c') shouldBe Vector("ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap", "aq", "ar", "as", "at", "au", "av", "aw", "ax", "ay", "az",
      "ba", "bc", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bk", "bl", "bm", "bn", "bo", "bp", "bq", "br", "bs", "bt", "bu", "bv", "bw", "bx", "by", "bz",
      "ca", "cb", "cd", "ce", "cf", "cg", "ch", "ci", "cj", "ck", "cl", "cm", "cn", "co", "cp", "cq", "cr", "cs", "ct", "cu", "cv", "cw", "cx", "cy", "cz")
  }

}

object CustomFlatMap {

  val chars : NumericRange.Inclusive[Char] = 'a' to 'z'

  def flatMapCharCombinations(charsRange: NumericRange[Char]): IndexedSeq[String] = {

    val perms = charsRange flatMap { a =>
      chars flatMap { b =>
        if (a != b) Seq("%c%c".format(a, b))
        else Seq()
      }
    }
    perms
  }

  def flatMapCharCombinationsYield (charsRange: NumericRange[Char]): IndexedSeq[String] = {
    val perms = for {
      a <- charsRange
      b <- chars
      if a != b
    } yield "%c%c".format(a, b)

    perms
  }
}
