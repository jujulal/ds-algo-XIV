package arrays

import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 5/9/16.
 */

class ArrayDataStructureSpec extends FlatSpec {

  "removeDuplicate" should "remove duplicate chars" in {
    val sentence = "dreamss"
    val word = RemoveDuplicatesFromString.removeDuplicate(sentence)
    assert(word == "dreams")
  }

  "uniqChars" should "count uniq chars" in {
    assert(!UniqueCharactersInString.hasUniqueCharacters("I am a dreamer in Portland"))
    assert(UniqueCharactersInString.hasUniqueCharacters("satle"))
  }


  "given identical words, areAnagrams" should "return true" in {
    assert(CharacterArrayAnagrams.areAnagrams("package", "agepack"))
  }

  "given different words, areAnagrams" should "return false" in {
    assert(!CharacterArrayAnagrams.areAnagrams("package", "items to ship"))
  }
}
