package hashTable

import org.scalatest.{FunSpec, FunSuite}

/**
  * Created by prayagupd
  * on 1/21/18.
  */

class RomanToDecimalSpec extends FunSpec {

  it("iterative") {
    assert(RomanToDecimal.romanToIntegerIterative("I") == 1)
    assert(RomanToDecimal.romanToIntegerIterative("II") == 2)
    assert(RomanToDecimal.romanToIntegerIterative("III") == 3)
    assert(RomanToDecimal.romanToIntegerIterative("IV") == 4)
    assert(RomanToDecimal.romanToIntegerIterative("V") == 5)
    assert(RomanToDecimal.romanToIntegerIterative("VI") == 6)
    assert(RomanToDecimal.romanToIntegerIterative("VII") == 7)
    assert(RomanToDecimal.romanToIntegerIterative("VIII") == 8)
    assert(RomanToDecimal.romanToIntegerIterative("IX") == 9)
    assert(RomanToDecimal.romanToIntegerIterative("X") == 10)

    assert(RomanToDecimal.romanToIntegerIterative("XXIV") == 204)
    assert(RomanToDecimal.romanToIntegerIterative("DCXXI") == 621)
  }

  it("rec") {
    assert(RomanToDecimal.romanToIntegerRecursive("I") == 1)
    assert(RomanToDecimal.romanToIntegerRecursive("II") == 2)
    assert(RomanToDecimal.romanToIntegerRecursive("III") == 3)
    assert(RomanToDecimal.romanToIntegerRecursive("IV") == 4)
    assert(RomanToDecimal.romanToIntegerRecursive("V") == 5)
    assert(RomanToDecimal.romanToIntegerRecursive("VI") == 6)
    assert(RomanToDecimal.romanToIntegerRecursive("VII") == 7)
    assert(RomanToDecimal.romanToIntegerRecursive("VIII") == 8)
    assert(RomanToDecimal.romanToIntegerRecursive("IX") == 9)
    assert(RomanToDecimal.romanToIntegerRecursive("X") == 10)

    assert(RomanToDecimal.romanToIntegerRecursive("XXIV") == 204)
    assert(RomanToDecimal.romanToIntegerRecursive("DCXXI") == 621)
  }
}
