package sorting.quick

/**
  * Created by prayagupd
  * on 6/8/16.
  * http://gauss.ececs.uc.edu/Courses/C321/html/quicksort.java.html
  * http://introcs.cs.princeton.edu/java/42sort/QuickSort.java
  */

object QuickSort {

  var originalArray = Array[Int]()

  def startSorting(array: Array[Int]): Array[Int] = {

    if (array == null || array.length == 0) {
      return null
    }

    this.originalArray = array
    sort(0, array.length - 1)

    originalArray
  }

  def sort(lowIndex: Int, highIndex: Int) {
    var low = lowIndex
    var high = highIndex
    // Get the pivot element from the middle of the list
    val pivotIndex = originalArray(lowIndex + (highIndex - lowIndex) / 2)

    // Divide into two lists
    while (low <= high) {
      // If the current value from the left list is smaller than the pivot
      // element then get the next element from the left list
      while (originalArray(low) < pivotIndex) {
        low = low + 1
      }
      // If the current value from the right list is larger then the pivot
      // element then get the next element from the right list
      while (originalArray(high) > pivotIndex) {
        high = high - 1
      }

      // If values in the left list larger than the pivot element
      // and if we have found a value in the right list
      // which is smaller than the pivot element then we exchange the values.
      if (low <= high) {
        exchange(low, high)
        low = low + 1
        high = high - 1
      }
    } //end of while

    if (lowIndex < high)
      sort(lowIndex, high)

    if (low < highIndex)
      sort(low, highIndex)

  } //end of quicksort

  def exchange(i: Int, j: Int) {
    val temp = originalArray(i)
    originalArray(i) = originalArray(j)
    originalArray(j) = temp
  }

}
