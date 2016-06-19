package sorting.merge

/**
 * Created by prayagupd
 * on 6/6/16.
 */

object MergeSort {

  var originalArray = Array[Int]()
  var tempArray = Array[Int]()
  
  def startSorting(array: Array[Int]) : Array[Int] = {
    this.originalArray = array
    val arraySize = array.length
    this.tempArray = Array.ofDim[Int](arraySize)
    sort(0, arraySize - 1)
    originalArray
  }

  def sort(lowIndex: Int, highIndex: Int) {
    if (lowIndex < highIndex) {
      val middleIndex = lowIndex + (highIndex - lowIndex) / 2
      sort(lowIndex, middleIndex)
      sort(middleIndex + 1, highIndex)
      merge(lowIndex, middleIndex, highIndex)
    }
  }

  def merge (lowIndex: Int,middleIndex: Int, highIndex: Int) {

    for (index <- lowIndex to highIndex) {
      tempArray(index) = originalArray(index)
    }

    var low = lowIndex
    var middle = middleIndex + 1
    var loww = lowIndex

    while (low <= middleIndex && middle <= highIndex) {
      if (tempArray(low) <= tempArray(middle)) {
        originalArray(loww) = tempArray(low)
        low = low + 1
      } else {
        originalArray(loww) = tempArray(middle)
        middle = middle + 1
      }
      loww = loww + 1
    }//end of while
    
    while (low <= middleIndex) {
      originalArray(loww) = tempArray(low)
      loww = loww + 1
      low = low + 1
    }
  }
}
