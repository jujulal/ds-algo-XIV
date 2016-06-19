package functionalProg.types

/**
 * Created by prayagupd
 * on 1/20/16.
 */

// This says that A has to be “viewable” as Int.
// see Spec
// https://twitter.github.io/scala_school/advanced-types.html

// You specify a view bound with <%
class Container[A <% Int] {

  def weight(w: A) = {
    28 + w
  }
}

class ContainerEqualsTo[A](value: A) {
  def weight(implicit evidence: A =:= Int) =
    28 + value
}

// viewable as doesn't work in 2.9+
//class ContainerViewable[A](value: A) {
//  def weight(implicit evidence: A <%< Int) =
//    28 + value
//}

