package arraysLinkedLists

import org.scalatest.FunSuite

import scala.collection.mutable

/**
 * Created by prayagupd
 * on 5/25/16.
 */

class RemoveDuplicateNodesSpec extends FunSuite {

  test("given string list with duplicate elements, should remove duplicates") {

    val artistsDocuments = new mutable.LinkedList[String]("Tycho",
      new mutable.LinkedList("Steven Wilson",
        new mutable.LinkedList("Tycho",
          new mutable.LinkedList("Gavin Guthrie",
            new mutable.LinkedList("Tycho", null)))))

    assert(artistsDocuments.size == 4)

    println("artistsDocuments 0 => " + artistsDocuments.head)
    println("artistsDocuments 1 => " + artistsDocuments(1))
    println("artistsDocuments 2 => " + artistsDocuments(2))
    println("artistsDocuments 3 => " + artistsDocuments(3))

    val uniqueArtists = RemoveDuplicateNodes.removeDuplicates(artistsDocuments)

    assert(uniqueArtists.size == 3)
    assert(uniqueArtists == mutable.LinkedList("Tycho", "Steven Wilson", "Gavin Guthrie"))
  }
}
