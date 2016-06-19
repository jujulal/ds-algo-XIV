package arraysLinkedLists

import org.scalatest.FunSuite

/**
 * Created by prayagupd
 * on 5/25/16.
 */

class ArrayListImplSpec extends FunSuite {

  test("should add items to array list") {
    val musicStartups = new ArrayListImpl()

    musicStartups.add("lastfm")
    musicStartups.add("Spotify")
    musicStartups.add("Pandora")

    assert(musicStartups.size == 3)
    assert(musicStartups.get(0) == "lastfm")
    assert(musicStartups.get(1) == "Spotify")
    assert(musicStartups.get(2) == "Pandora")
  }


  test("should search items in array list") {
    val musicStartups = new ArrayListImpl()

    musicStartups.add("lastfm")
    musicStartups.add("Spotify")
    musicStartups.add("Pandora")

    assert(musicStartups.size == 3)
    assert(musicStartups.search("Spotify"))
  }
}
