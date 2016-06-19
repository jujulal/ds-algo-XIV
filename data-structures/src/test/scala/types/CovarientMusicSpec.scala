package types

import functionalProg.types.{CovarientMusicBand, MetalBand}
import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

/**
 * http://like-a-boss.net/2012/09/17/variance-in-scala.html
 * Created by prayagupd
 * on 1/19/16.
 */

class CovarientMusicSpec extends FlatSpec {

  "seq of covarient music band" should "handle metal bands" in {
    val metalBand1: Seq[CovarientMusicBand] = ListBuffer(new MetalBand, new MetalBand)
    //    metalBand1:+ new MetalBand
    //    metalBand1:+ new MetalBand
    assert(2 == metalBand1.size)
  }

  "seq of metal band" should "handle metal bands" in {
    val metalBand2 : Seq[MetalBand] = ListBuffer(new MetalBand, new MetalBand)
    assert(2 == metalBand2.size)

    // not allowed
    // varient = super
    //val metalBand3 : Seq[MetalBand] = ListBuffer.empty[CovarientMusicBand]

  }
}
