import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sequence of positive integers A (patient visits in a month) and an integer T (total continious visits),
 * return whether there is a continuous sequence of A that sums up to exactly T
 Example
 [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20
 [1, 3, 5, 23, 2], 8.      Return True because 3 + 5 = 8
 [1, 3, 5, 23, 2], 7       Return False because no sequence in this array adds up to 7

 Complexity - O(n2)
 */

public class ContiniousSumCheck {

	public static boolean continiousSumCheck(int[] sequence, final int checkWith) throws Exception {
    int sum = 0;
    for (int index = 0 ; index < sequence.length-1 ; index++) {
      if (sequence[index] > checkWith) {
        sum = 0;
        continue;
      }
      sum += sequence[index];
      System.out.println(" sum += sequence[index] for " + sequence[index] + " : " + sum);

      // if for loop to get index was was used, complexity would have been O(n2)
      for (int nextIndex = index+1 ; nextIndex < sequence.length ; nextIndex++){
        sum+=sequence[nextIndex];
        System.out.println(" next sum += sequence[index] => " + sequence[nextIndex] + " : " + sum);
        if (sum > checkWith) {
          sum = 0;
          break;
        }
        if (sum == checkWith) return true;
      }
      if (sum > checkWith) {
        sum = 0;
        continue;
      }
      if (sum == checkWith) return true;
    }

    return false;
	}

	public static void main (String[] args) throws Exception {
		final int[] array1 = { 23, 5, 4, 7, 2, 11 };
    final int[] array2 = {1, 3, 5, 23, 2};
    final boolean sumMatches1 = continiousSumCheck(array1, 20);
    final boolean sumMatches2 = continiousSumCheck(array2, 8);
		System.out.println(array1 + " has continious sum : " + sumMatches1);
    System.out.println(array2 + " has continious sum : " + sumMatches2);
	}

  //reads a string from the keyboard input
  public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
  }

  static double sum = 0;
  public static double sum(Double[] sequence) throws Exception {

    final List<Double> list = Arrays.asList(sequence);
    list.forEach(n -> {
      sum += n;
    });
    return sum;
  }
}
