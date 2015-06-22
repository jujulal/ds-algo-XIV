package com.zazzercode.quick;

import java.io.*;
import java.util.*;

/**
  * @author : prayagupd
  * @see : http://gauss.ececs.uc.edu/Courses/C321/html/quicksort.java.html
  * @see : http://introcs.cs.princeton.edu/java/42sort/QuickSort.java
  **/

public class QuickSort {

  private int[] numbers;
  private int number;

  public void sort(int[] values) {
    // check for empty or null array
    if (values ==null || values.length==0){
      return;
    }
    this.numbers = values;
    number = values.length;
    quicksort(0, number - 1);
  }

  private void quicksort(int low, int high) {
    int l = low; 
    int h = high;
    // Get the pivot element from the middle of the list
    int pivot = numbers[low + (high-low)/2];

    // Divide into two lists
    while (l <= h) {
      // If the current value from the left list is smaller then the pivot
      // element then get the next element from the left list
      while (numbers[l] < pivot) {
        l++;
      }
      // If the current value from the right list is larger then the pivot
      // element then get the next element from the right list
      while (numbers[h] > pivot) {
        h--;
      }

      // If we have found a values in the left list which is larger then
      // the pivot element and if we have found a value in the right list
      // which is smaller then the pivot element then we exchange the
      // values.
      // As we are done we can increase i and j
      if (l <= h) {
        exchange(l, h);
        l++;
        h--;
      }
    }//end of while
    // Recursion
    if (low < h)
      quicksort(low, h);
    if (l < high)
      quicksort(l, high);
  }//end of quicksort

  private void exchange(int i, int j) {
    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
  }

}
