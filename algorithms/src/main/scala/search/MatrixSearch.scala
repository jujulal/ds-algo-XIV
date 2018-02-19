package search

import java.util.concurrent.atomic.AtomicBoolean

/**
  * https://leetcode.com/problems/word-search/description/
  * Given a 2D board and a word, find if the word exists in the grid.
  *
  * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
  * those horizontally or vertically neighboring. The same letter cell may not be used more than once.
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
      val right = search((currentNode._1, currentNode._2 + 1), graph, searchIndex + 1, searchWord, matches :+ currentNode)
      val bottom = search((currentNode._1 + 1, currentNode._2), graph, searchIndex + 1, searchWord, matches :+ currentNode)

      if (right.length == searchWord.length) right
      else if (bottom.length == searchWord.length) bottom
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
