package functionalProg.types

/**
 * Created by prayagupd
 * on 1/19/16.
 */

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
