package search

import org.scalatest.FunSuite

class CountCamelCaseSpecs extends FunSuite {

  test("count camel case") {

    assert(CountCamelCase.camelCaseCount("iFukcingLoveMusic") == 3)

  }

}
