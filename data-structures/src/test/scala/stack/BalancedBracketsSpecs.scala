package stack

import org.scalatest.{FunSuite, Matchers}

class BalancedBracketsSpecs extends FunSuite with Matchers {

  test("checks {}") {
    BalancedBrackets.isBalanced("{}") shouldBe true
  }

  test("[()()]") {
    BalancedBrackets.isBalanced("[{()}]") shouldBe true

    BalancedBrackets.isBalanced("[()()]") shouldBe true
  }

  test("does not validate") {
    BalancedBrackets.isBalanced("[{]}") shouldBe false
  }

  test("only applies for [] {} and (), length <= 1000") {

    BalancedBrackets.isBalanced("abc") shouldBe false

  }

  /**
    * https://hr-testcases-us-east-1.s3.amazonaws.com/23954/input00.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1503202846&Signature=SKAmo3AadiurFBEviFKu2mSA1Vk%3D&response-content-type=text%2Fplain
    */
  test("hackerrank") {
    BalancedBrackets.isBalanced("}][}}(}][))]") shouldBe false
    BalancedBrackets.isBalanced("[](){()}") shouldBe true
    BalancedBrackets.isBalanced("({}([][]))[]()") shouldBe true
    BalancedBrackets.isBalanced("{)[](}]}]}))}(())(") shouldBe false

    val cases =
      """()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}
{][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))[
[)](][[([]))[)
]}]){[{{){
{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){[
()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})
){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{
[(})])}{}}]{({[]]]))]})]
[{
{}([{()[]{{}}}])({})
{({}{[({({})([[]])}({}))({})]})}
()[]
{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()((
[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}
(}]}
(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}
[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}
()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]
({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[[
)}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{
}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}""".stripMargin.split("\\n")

    val results =
      """YES
NO
NO
NO
NO
NO
NO
NO
NO
YES
YES
YES
NO
YES
NO
YES
NO
YES
NO
NO
NO""".stripMargin.split("\\n")

    cases.zipWithIndex.foreach { case (e: String, index: Int) =>
      val bool = if (results(index).equals("YES")) true else false
      println(e)
      BalancedBrackets.isBalanced(e) shouldBe bool
    }
  }
}
