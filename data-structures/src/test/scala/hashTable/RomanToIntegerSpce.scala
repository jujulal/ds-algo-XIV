package hashTable

import org.scalatest.FunSuite

/**
  * Created by prayagupd
  * on 1/21/18.
  */

class RomanToIntegerSpce extends FunSuite {

  assert(RomanToInteger.romanToInteger("I") == 1)
  assert(RomanToInteger.romanToInteger("II") == 2)
  assert(RomanToInteger.romanToInteger("III") == 3)
  assert(RomanToInteger.romanToInteger("IV") == 4)
  assert(RomanToInteger.romanToInteger("V") == 5)
  assert(RomanToInteger.romanToInteger("VI") == 6)
  assert(RomanToInteger.romanToInteger("VII") == 7)
  assert(RomanToInteger.romanToInteger("VIII") == 8)
  assert(RomanToInteger.romanToInteger("IX") == 9)
  assert(RomanToInteger.romanToInteger("X") == 10)

  assert(RomanToInteger.romanToInteger("XXIV") == 204)
  assert(RomanToInteger.romanToInteger("DCXXI") == 621)
}
