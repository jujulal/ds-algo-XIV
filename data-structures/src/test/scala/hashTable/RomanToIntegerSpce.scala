package hashTable

import org.scalatest.{FunSpec, FunSuite}

/**
  * Created by prayagupd
  * on 1/21/18.
  */

class RomanToIntegerSpce extends FunSpec {

  it("iterative") {
    assert(RomanToInteger.romanToIntegerIterative("I") == 1)
    assert(RomanToInteger.romanToIntegerIterative("II") == 2)
    assert(RomanToInteger.romanToIntegerIterative("III") == 3)
    assert(RomanToInteger.romanToIntegerIterative("IV") == 4)
    assert(RomanToInteger.romanToIntegerIterative("V") == 5)
    assert(RomanToInteger.romanToIntegerIterative("VI") == 6)
    assert(RomanToInteger.romanToIntegerIterative("VII") == 7)
    assert(RomanToInteger.romanToIntegerIterative("VIII") == 8)
    assert(RomanToInteger.romanToIntegerIterative("IX") == 9)
    assert(RomanToInteger.romanToIntegerIterative("X") == 10)

    assert(RomanToInteger.romanToIntegerIterative("XXIV") == 204)
    assert(RomanToInteger.romanToIntegerIterative("DCXXI") == 621)
  }

  it("rec") {
    assert(RomanToInteger.romanToIntegerRecursive("I") == 1)
    assert(RomanToInteger.romanToIntegerRecursive("II") == 2)
    assert(RomanToInteger.romanToIntegerRecursive("III") == 3)
    assert(RomanToInteger.romanToIntegerRecursive("IV") == 4)
    assert(RomanToInteger.romanToIntegerRecursive("V") == 5)
    assert(RomanToInteger.romanToIntegerRecursive("VI") == 6)
    assert(RomanToInteger.romanToIntegerRecursive("VII") == 7)
    assert(RomanToInteger.romanToIntegerRecursive("VIII") == 8)
    assert(RomanToInteger.romanToIntegerRecursive("IX") == 9)
    assert(RomanToInteger.romanToIntegerRecursive("X") == 10)

    assert(RomanToInteger.romanToIntegerRecursive("XXIV") == 204)
    assert(RomanToInteger.romanToIntegerRecursive("DCXXI") == 621)
  }
}
