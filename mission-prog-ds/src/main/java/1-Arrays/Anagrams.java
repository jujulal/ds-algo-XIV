import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.4 Write a method to decide if two strings are anagrams or not.
 *
 * write Junit for cases
 *
 * NVIDIA
 * http://www.careercup.com/question?id=8641795
 *
 * Time Complexity – O(n) (time to go through the arrays at once)
 * Space Complexity – O(1) (Only a finite array needed depending on how many different chars we may have)
 * http://www.fitcoding.com/2014/02/10/two-strings-are-anagrams-java/
 *
 * http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 *
 * NOTE: if done by sorting both strings and comparing each char
 * Sorting an array, Arrays.sort(string1Array);  =>  Time – O(n*log(n))
 *
 * Google
 * Given two strings a and b, find whether any anagram of string a is a sub-string of string b. For eg:
 if a = xyz and b = afdgzyxksldfm then the program should return true.
 http://www.careercup.com/question?id=5389078581215232
 * 03-26-2015, Iowa
 */

public class Anagrams {

  /**
   *
   * time : O(n) + O(n)
   */
	public static boolean isAnagram(String string1, String string2) {
    if (string1 == null || string2 == null)
      return false;
    if (string1.length() != string2.length())
      return false;

    char[] string1Array = string1.toCharArray();
    char[] string2Array = string2.toCharArray();

    int[] letterCounts = new int[256];

    //for (int index = 0 ; index < string1Array.length ; index++) {
    //  letterCounts[string1Array[index]]++;
    //}
    //
    //for(int index = 0; index < string2Array.length ; index++) {
    //  if (letterCounts[string2Array[index]]==0) {
    //    return false;
    //  }
    //  letterCounts[string2Array[index]]--;
    //}

    // calculate counts, same as two separate operations above - O(n)
    for(int index = 0; index < string1Array.length ; index++) {
      letterCounts[string1Array[index]]++;
      letterCounts[string2Array[index]]--;
    }

    //check if everything is balanced - O(n)
    for (int index = 0 ; index < letterCounts.length; index++) {
      if (letterCounts[index]!=0) {
        return false;
      }
    }
    return true;
	}

	public static void main (String[] args) throws IOException {
    System.out.println("Enter string 1 : ");
		String str1 = getString(); //args[0];

    System.out.println("Enter string 2 : ");
    String str2 = getString(); //args[0];

    boolean isAnagram = isAnagram(str1, str2);
		System.out.println(isAnagram);
	}

  //reads a string from the keyboard input
  public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
  }

}
