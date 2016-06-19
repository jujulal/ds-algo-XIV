package bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * by prayagupd
 * on 2/21/15.
 *
   4.1
   Implement a function to check if a tree is balanced. For the purposes of this question,
   a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
   from the root by more than one.

 * http://stackoverflow.com/a/4054711/432903
 */


public class BitManipulationTests {
  public static void main(String[] args) {
    //Left shift is the same as multiplying by 2,
    //The signed left shift operator "<<" shifts a bit pattern to the left

    // while right shift is integer divide by 2

    //Now, int is of 4 bytes,hence 32 bits. So when you do shift by 33, it's equivalent to shift by 1.
    long maskLeftShiftBy31 = 9 << 31;
    long maskLeftShiftBy33 = 2 << 33; // 10 << 33=32+1=1
    System.out.println(maskLeftShiftBy31 + " - " + Integer.toBinaryString(2 << 31));
    System.out.println(maskLeftShiftBy33 + " - " + Integer.toBinaryString(2 << 33));

  }
}


