import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Find the first non-repeating character in a stream of characters?
 *
 * http://www.careercup.com/question?id=4569644446777344
 *
 * O(n) time and
 * O(1) space
 */

public class FirstUniqueChar {

	public static char findFirstUniqueChar(char[] stringArray) throws Exception {
    if (stringArray == null) throw new Exception("Empty array.");

    int[] charTable = new int[256];
    for (char c : stringArray) {
      charTable[c]++;
    }

    //O(length)
    for(int index = 0; index < stringArray.length ; index++ ) {
      if (charTable[stringArray[index]] == 1) return stringArray[index];
    }
		throw new Exception("no unique char found");
	}

	public static void main (String[] args) throws Exception {
    System.out.println("Enter string to find first unique char : "); //applea
		String str = getString(); //args[0];
    char unique = findFirstUniqueChar(str.toCharArray()); //l
		System.out.println(str + " has first unique char : " + unique);
	}

  //reads a string from the keyboard input
  public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
  }

}
