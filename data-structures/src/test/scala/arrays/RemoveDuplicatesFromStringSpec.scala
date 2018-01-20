package arrays

import org.scalatest.FlatSpec

/**
  * Created by prayagupd
  * on 1/20/18.
  */
class RemoveDuplicatesFromStringSpec extends FlatSpec {

  "removeDuplicate" should "remove duplicate chars" in {

    assert(RemoveDuplicatesFromString.removeDuplicateRec("geeksforgeeks") == "for")
    assert(RemoveDuplicatesFromString.removeDuplicateRec("aabbccddef") == "ef")
    assert(RemoveDuplicatesFromString.removeDuplicateRec("aabbccdd") == "")

  }

}
