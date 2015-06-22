package com.zazzercode.merge;

import java.util.logging.Logger;

/**
 * @see : http://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java
 * @see : http://www.buildingjavaprograms.com/code-files/2ed/ch13/MergeSort.java
 * */

public class MergeSort {

  private Logger logger = Logger.getLogger("MergeSort");
  private int[] numbers;
  private int[] helper;

  private int number; //length

  public void sort(int[] values) {
    this.numbers = values;
    number = values.length;
    this.helper = new int[number];
    mergeSort(0, number - 1);
  }

  private void mergeSort(int low, int high) {
    loggerinfo( "check if " + low + " < " + high + ", if not then the array is sorted" );
    if (low < high) {

      //logger.info( "Get the index of the element which is in the middle" );
      int middle = low + (high - low) / 2;
      loggerinfo( "Sort the left (" + low  + "," + high + ") side of the array" );
      mergeSort(low, middle);
      
      loggerinfo( "Sort the right side of the array for (" + (middle+1) + "," + high + ")");
      mergeSort(middle + 1, high);
      
      loggerinfo( "Merge them both (" + low + "," + middle + "," + high + ")");
      merge(low, middle, high);
    }
  }

  private void merge(int low, int middle, int high) {

    loggerinfo( "Copy both parts into the helper array" );
    loggerinfo("numbers");
    array(numbers);
    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }
   
    loggerinfo("");
    loggerinfo("helpers");
    array(helper);
    loggerinfo("");
    int i = low;
    int j = middle + 1;
    int k = low;
    loggerinfo( "Copy the smallest values from either the left or the right side back " +
    " to the original array ");
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        i++;
      } else {
        numbers[k] = helper[j];
        j++;
      }
      k++;
    }//end of while
    loggerinfo( "Copy the rest of the left side of the array into the target array" );
    while (i <= middle) {
      numbers[k] = helper[i];
      k++;
      i++;
    }

  }

  private void loggerinfo(final String message){
	  System.out.println(message);
  }

  private void array(final int[] arr){
	  for (int a : arr) {
	  	System.out.print(a+", ");
	  }
  }
}
