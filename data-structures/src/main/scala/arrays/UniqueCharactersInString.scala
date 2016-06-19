package arrays

/**
  * 1.1 Implement an algorithm to determine if a string has all unique characters. 
  * What if you can not use additional data structures?
  *
  * Time complexity is O(n), where n is the length of the string, and 
  * space complexity is O(n)
  * usage : scala UniqueCharacters.scala prayag
  */

object UniqueCharactersInString {
	
	def hasUniqueCharacters(sentence : String ) : Boolean = {
		val characterSet = new Array[Boolean](255) //space of length n
		for ( i <- 0 until sentence.length() by 1) {
			val character = sentence.charAt(i)
			if ( characterSet(character) )
				return false
			characterSet(character) = true
		}
		return true
	}
	
}

/**
  * Check every char of the string with every other char of the string for duplicate occurrences. 
  * Time complexity O(n^2) and //but we need to be faster as long as we ve got enough space
  * no space.
  */
