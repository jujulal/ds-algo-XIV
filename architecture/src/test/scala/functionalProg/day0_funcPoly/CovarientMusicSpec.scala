package functionalProg.day0_funcPoly

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

/**
 * http://like-a-boss.net/2012/09/17/variance-in-scala.html
  *
 * Created by prayagupd
 * on 1/19/16.
 */

class CovarientMusicSpec extends FlatSpec with Matchers {

  class CovarientMusicBand {
    var name = "music"
    def sound (): Unit = {
      println("music")
    }
  }

  class MetalBand extends CovarientMusicBand {
    name = "metal"
    override def sound() : Unit = {
      println("metal")
    }
  }

  class RockBand extends CovarientMusicBand {
    name = "rock"
    override def sound() : Unit = {
      println("rock")
    }
  }

  // bound
  // Scala allows you to restrict polymorphic variables using bounds. These bounds express subtype relationships.
  // https://twitter.github.io/scala_school/type-basics.html
  class MusicRecordLabel {
    def record[T <: CovarientMusicBand](band: T): Unit = {
      band.sound()
    }
  }

  "seq of covarient music band" should "handle metal bands" in {
    val metalBand1: Seq[CovarientMusicBand] = ListBuffer(new MetalBand, new MetalBand)
    //    metalBand1:+ new MetalBand
    //    metalBand1:+ new MetalBand
    metalBand1.size shouldBe 2
  }

  "seq of metal band" should "handle metal bands" in {
    val metalBand2 : Seq[MetalBand] = ListBuffer(new MetalBand, new MetalBand)
    metalBand2.size shouldBe 2

    // not allowed
    // varient = super
    //val metalBand3 : Seq[MetalBand] = ListBuffer.empty[CovarientMusicBand]

  }
}
