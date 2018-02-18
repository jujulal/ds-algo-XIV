package search

import java.util.concurrent.atomic.AtomicBoolean

/**
  * https://leetcode.com/problems/word-search/description/
  */

object MatrixSearch {

  private def search(currentNode: (Int, Int),
                     graph: Array[Array[Char]],
                     searchIndex: Int,
                     searchWord: String,
                     matches: IndexedSeq[(Int, Int)]): IndexedSeq[(Int, Int)] = {

    if (searchIndex == searchWord.length) {
      matches
    } else if (currentNode._1 > graph.length - 1 || currentNode._2 > graph.head.length - 1) {
      matches
    } else if (currentNode._1 < graph.length && graph(currentNode._1)(currentNode._2) != searchWord.charAt(searchIndex)) {
      matches
    } else {
      val horizontal = search((currentNode._1, currentNode._2 + 1), graph, searchIndex + 1, searchWord, matches :+ currentNode)
      val vertical = search((currentNode._1 + 1, currentNode._2), graph, searchIndex + 1, searchWord, matches :+ currentNode)

      if (horizontal.length == searchWord.length) horizontal
      else if (vertical.length == searchWord.length) vertical
      else matches
    }

  }

  def search(matrix: Array[Array[Char]], word: String): IndexedSeq[(Int, Int)] = {

    val stopSearch = new AtomicBoolean(false)
    var searchNodes = IndexedSeq.empty[(Int, Int)]

    for (row <- 0 to matrix.length; if !stopSearch.get()) {
      for (col <- 0 to matrix.head.length; if !stopSearch.get()) {
        val s = search((row, col), matrix, 0, word, IndexedSeq.empty)
        if (s.length == word.length) {
          stopSearch.set(true)
          searchNodes = s
        }
      }
    }

    searchNodes
  }

}
