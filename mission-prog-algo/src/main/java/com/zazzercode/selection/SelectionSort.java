package com.zazzercode.selection;

import java.util.Arrays;

public class SelectionSort {

/**
 * worst case comparisons = n ( n - 1 ) /2 
 * @see : http://courses.cs.washington.edu/courses/cse373/01wi/slides/Measurement/sld010.htm
 */	

 public int[] sort(int[] array, String type){

   if("ascending".equals(type)){
     for (int j = 1 ; j < array.length ; j++) {
	    final int key = array[ j ];
	    
	    int previousIndex = j - 1;
	    while(previousIndex >= 0 && array[ previousIndex ] > key ){
		    array[ previousIndex + 1] = array[ previousIndex ];
		    previousIndex--;
	    }

	    array[ previousIndex + 1 ] = key;
     }
   }
  
   return array;
 }	


}
