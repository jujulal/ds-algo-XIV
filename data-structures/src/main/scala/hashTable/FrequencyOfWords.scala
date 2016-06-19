package hashTable

import scala.collection.mutable

/**
  *
  * 19.8 Design a method to find the frequency of occurrences of any given word in a book.
  *
  * Solution: Repetitive Queries
  */

object FrequencyOfWords {

	def buildFrequencyTable ( book : Array[String] ) : mutable.HashMap[String, Integer] = {
		val hashTable = mutable.HashMap.empty[String, Integer] //Space complexity < n (length of dictionary array)

		//Time complexity (n)
		book.foreach { word =>
			if (word.toLowerCase.trim() != "" ) {
				if(!hashTable.contains(word.toLowerCase)) {
					hashTable(word.toLowerCase) = 0
				}
				hashTable += word.toLowerCase -> (hashTable(word.toLowerCase) + 1)
			}
		}
		println(hashTable)
		hashTable
	}

	def getFrequency (frequencyTable : mutable.HashMap[String, Integer], word : String) : Int = {
		if(frequencyTable.contains(word.toLowerCase)) {
			return frequencyTable(word.toLowerCase)
		}
		0
	}

}
