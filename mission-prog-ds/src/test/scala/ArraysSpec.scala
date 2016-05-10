import org.scalatest.FlatSpec

/**
 * Created by prayagupd
 * on 5/9/16.
 */

class ArraysSpec extends FlatSpec {

  "removeDuplicate" should "remove duplicate chars" in {
    val sentence = "dreamss"
    val word = RemoveDuplicatesFromString.removeDuplicate(sentence)
    assert(word == "dreams")
  }

  "uniqChars" should "count uniq chars" in {
    assert(UniqueCharactersInString.isUniqueCharacters("I am a dreamer in Portland") == false)
    assert(UniqueCharactersInString.isUniqueCharacters("abc") == true)
  }

}
