package com.zazzercode.quick;

import java.io.*;
import java.util.*;

/**
  * @author : prayagupd
  * @see : http://gauss.ececs.uc.edu/Courses/C321/html/quicksort.java.html
  **/

public class QuickSortTest {

   public void swap (int A[], int x, int y) {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
   }

   // Reorganizes the given list so all elements less than the first are 
   // before it and all greater elements are after it.                   
   public int partition(int A[], int low, int h) {
      int pivot = A[low];
      while (low < h) {
         if (A[low] == pivot || A[h] == pivot) {
            System.out.println("Only distinct integers allowed - C321");
            System.out.println("students should ignore this if statement");
            //System.out.exit(0);
         }
         while (A[low] < pivot) low++;
         while (A[h] > pivot) h--;
         swap (A, low, h);
      }
      return low;
   }

   public void sort(int A[], int low, int high) {
      if (low >= high) return;
      int pivot_index = partition(A, low, high);
      sort(A, low, pivot_index);
      sort(A, pivot_index+1, high);
   }

   // All integers must be distinct
}
