package arrays

/**
  * CTCI 1.3
  * Design an algorithm and write code to remove the duplicate characters in a string
  * without using any additional buffer. 
  *
  * NOTE: One or two additional variables are fine.
  * An extra copy of the array is not.
  *
  * FOLLOW UP
  * Write the test cases for this method.
  *
  * https://www.careercup.com/question?id=6704038393413632
  */


object RemoveDuplicatesFromString {

  def removeDuplicateRec(word: String): String = {

    def compare(word:String, follower: Int, leader: Int): String = {
      if(word.length - 1 == follower || word.isEmpty) word

      else if(word(follower) == word(leader) && leader == word.length -1 )
        compare(word.substring(0, follower) + word.substring(follower + 1, leader), 0, 1)

      else if(word(follower) == word(leader))
        compare(word.substring(0, follower) + word.substring(follower + 1, leader) + word.substring(leader + 1), 0, 1)

      else if(word.length - 1 == leader)
          compare(word, follower + 1, follower + 2)

      else compare(word, follower, leader + 1)
    }

    compare(word, 0, 1)
  }
}
