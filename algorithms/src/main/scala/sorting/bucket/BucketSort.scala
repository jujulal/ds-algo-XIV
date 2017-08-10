package sorting.bucket

/**
  * Created by prayagupd
  * on 6/19/16.
  */

object BucketSort {

  def sort(array: Array[Int]): Array[Int] = {

    var bucketBoundry = 0

    //find max elem - O(n)
    for (index <- 0 until array.length) {
      if (array(index) > bucketBoundry) bucketBoundry = array(index)
    }

    val sizeOfBucket = bucketBoundry / array.length

    //create distribution buckets/ partitions - O(sizeOfPartitions)
    val partitions = (0 to bucketBoundry by sizeOfBucket)
      .map(index => ((index, index + sizeOfBucket), Array.fill(sizeOfBucket) {
        -1
      }))

    //distribute elements - O(n * number of partitions * each partition size for assignment)
    for (elemIndex <- 0 until array.length) {
      for (partitionIndex <- 0 until partitions.length) { //TODO exit the iteration once partition is figured out

        if (array(elemIndex) >= partitions(partitionIndex)._1._1 && array(elemIndex) < partitions(partitionIndex)._1._2) {

          //distribute to partition - O(n)
          var arrayIndex = 0
          var keepIter = true
          while (arrayIndex < partitions(partitionIndex)._2.length && keepIter) {
            if (partitions(partitionIndex)._2(arrayIndex) == -1) {
              partitions(partitionIndex)._2(elemIndex) = array(elemIndex)
              keepIter = false
            }
            arrayIndex = arrayIndex + 1
          }
        }
      }
    }

    //TODO sort each bucket again

    val sortedArray = new Array[Int](array.length)

    var index = 0
    partitions.foreach(p => {
      p._2.filter(v => v != -1).foreach { value =>
        sortedArray(index) = value
        index = index + 1
      }
    })

    sortedArray
  }
}
