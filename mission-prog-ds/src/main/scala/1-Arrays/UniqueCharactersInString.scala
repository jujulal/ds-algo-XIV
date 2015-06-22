
/**
  * 1.1 Implement an algorithm to determine if a string has all unique characters. 
  * What if you can not use additional data structures?
  *
  * Time complexity is O(n), where n is the length of the string, and 
  * space complexity is O(n)
  * usage : scala UniqueCharacters.scala prayag
  */

object UniqueCharactersInString {
	def isUniqueCharacters(sentence : String ) : Boolean = {
		val charSet = new Array[Boolean](255) //space of length n
		//Array[Boolean] charSet = new Array[Boolean](255)
		for ( i <- 0 until sentence.length() by 1) {
			val character = sentence.charAt(i)
			if ( charSet(character) ) 
				return false
			charSet(character) = true
		}
		return true
	}

	def main (args : Array[String]) {
		val sentence = args(0)
		val isUnique = isUniqueCharacters(sentence)
		if(isUnique)
			println(s"$sentence is unique")
		else
			println(s"$sentence is not unique")

	}
}

/**
  * Check every char of the string with every other char of the string for duplicate occurrences. 
  * Time complexity O(n^2) and //but we need to be faster as long as we ve got enough space
  * no space.
  */
