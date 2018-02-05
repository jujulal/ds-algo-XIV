package arrays

/**
  * https://en.wikipedia.org/wiki/ROT13
  * https://en.wikipedia.org/wiki/Caesar_cipher
  * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
  */

object CaesarEncryption {

  def encrypt(s: String, k: Int): String = {

    var encrypted = ""

    for (i <- 0 until s.length;
         ascii = s.charAt(i).toInt;
         newAscii = ascii + k) {

      if (ascii >= 65 && ascii <= 90 && newAscii > 90) {
        val n = (newAscii % 90) % 26
        val newAsciii = if (n == 0) 90 - n
        else 64 + n
        encrypted = encrypted + newAsciii.toChar

      } else if (ascii >= 65 && ascii <= 90)
        encrypted = encrypted + newAscii.toChar

      else if (ascii >= 97 && ascii <= 122 && newAscii > 122) {
        val newAsciii = (newAscii % 122) % 26
        val n = if (newAsciii == 0) 122 - newAsciii
        else 96 + newAsciii
        encrypted = encrypted + n.toChar

      } else if (ascii >= 97 && ascii <= 122)
        encrypted = encrypted + newAscii.toChar

      else
        encrypted = encrypted + ascii.toChar
    }

    encrypted

  }

}
