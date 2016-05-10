
import scala.util.control._

/**
  * 1.3
  * Design an algorithm and write code to remove the duplicate characters in a string
  * without using any additional buffer. 
  *
  * NOTE: One or two additional variables are fine.
  * An extra copy of the array is not.
  *
  * FOLLOW UP
  * Write the test cases for this method.
  * usage : scala UniqueCharacters.scala prayag
  */

object RemoveDuplicatesFromString {
	def removeDuplicate(word : String ) : String = {
		val len :Int = word.length()
		//if ( len < 2 ) {
		//	return ""
		//}

		val wordArray = word.toArray
		var tailIndex = 1
		for ( compareToIndex <- 1 until word.length() by 1) {
                       val loop = new Breaks
		       var compareIndex = 0
                       loop.breakable {
			while (compareIndex < tailIndex) {
				println(s"compareIndex $compareIndex == compareToIndex $compareToIndex")
				if (wordArray(compareIndex) == wordArray(compareToIndex)) {
					loop.break
				}
				compareIndex+=1
			} //end of duplicate char compare
		       }
		       println(s"for compareToIndex $compareToIndex => compare compareIndex $compareIndex== tailIndex $tailIndex")
		       if (compareIndex == tailIndex) {
				wordArray(tailIndex) = wordArray(compareToIndex)
				tailIndex+=1
		       }
		       println("=========================")
		} //end of compareToIndex

		wordArray(tailIndex)=0
		return new String(wordArray)
	}
}
