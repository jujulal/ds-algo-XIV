package arrays

import org.scalatest.FunSuite

class CaesarEncryptionSpecs extends FunSuite {

  test("rotate by more than 26") {
    assert(CaesarEncryption.encrypt("1", 75) == "1")
    assert(CaesarEncryption.encrypt("l", 98) == "f")
    assert(CaesarEncryption.encrypt("c", 98) == "w")
    assert(CaesarEncryption.encrypt("f", 98) == "z")
    assert(CaesarEncryption.encrypt("d", 98) == "x")
    assert(CaesarEncryption.encrypt("lcfd", 98) == "fwzx")
    assert(CaesarEncryption.encrypt("LCFD", 98) == "FWZX")
  }

  test("encrypts a lowercase word with key 1") {

    assert(CaesarEncryption.encrypt("abc", 2) == "cde")
    assert(CaesarEncryption.encrypt("abc-", 2) == "cde-")
    assert(CaesarEncryption.encrypt("az", 2) == "cb")
    assert(CaesarEncryption.encrypt("a", 25) == "z")
    assert(CaesarEncryption.encrypt("a", 50) == "y")
    assert(CaesarEncryption.encrypt("a", 75) == "x")
    assert(CaesarEncryption.encrypt("a", 100) == "w")

    //97+100 => (197 % 122) = 75 % 26
    //122+100 => (222 % 122) = 100 % 26
    assert(CaesarEncryption.encrypt("az", 100) == "wv")
  }

  test("encrypts caps word with key 2") {
    assert(CaesarEncryption.encrypt("AZ-", 2) == "CB-")
    assert(CaesarEncryption.encrypt("AZa-z", 2) == "CBc-b")
  }
}
