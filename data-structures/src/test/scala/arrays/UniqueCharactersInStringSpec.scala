package arrays

import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 5/9/16.
 */

class UniqueCharactersInStringSpec extends FlatSpec {

  "uniqChars" should "count uniq chars" in {
    assert(!UniqueCharactersInString.hasUniqueCharacters("I am a dreamer in Portland"))
    assert(UniqueCharactersInString.hasUniqueCharacters("satle"))
  }
}
