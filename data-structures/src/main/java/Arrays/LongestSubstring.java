package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prayagupd
 * on 7/31/17.
 */

public class LongestSubstring {

    public int solution(String S) {

        //stores length of longest sequence
        int lengthOfLongestSequence = -1;

        //holds current longest sequence
        StringBuilder longestSequence = new StringBuilder();

        //flag to check if the current longest sequence has Uppercase in it
        boolean sequenceHasUpperCase = false;

        //check invalid case
        if (S == null || S.length() > 200 ) return -1;

        //iterates over input until a digit is found
        //time complexity is O(n)
        //space complexity is O(n)
        for (int index = 0; index < S.length(); index++) {

            char currentCharacter = S.charAt(index);

            //check if the character is other than digits with ascii [48-57] and
            // alphabets ascii [65-90] or [97-122]
            if (!(currentCharacter >= 48 && currentCharacter <= 57) &&
                    !(currentCharacter >= 65 && currentCharacter <= 90) &&
                    !(currentCharacter >= 97 && currentCharacter <= 122)) {
                lengthOfLongestSequence = -1;
                longestSequence = new StringBuilder();
                break;
            }

            //check if the character is a number
            //if so, calculate the length of accumulated string and assign
            // to longest substring length

            //otherwise keep accumulating the characters
            if (currentCharacter >= 48 && currentCharacter <= 57) {
                if (sequenceHasUpperCase && longestSequence.length() > lengthOfLongestSequence) {
                    lengthOfLongestSequence = longestSequence.length();
                }
                sequenceHasUpperCase = false;
                longestSequence = new StringBuilder();
                continue;
            }

            //keep accumulating the characters until number is found
            longestSequence.append(currentCharacter);

            //check if the character is UPPERCASE
            //uppercase alphabet has ascii [65-90]
            if (currentCharacter >= 65 && currentCharacter <= 90) {
                sequenceHasUpperCase = true;
            }

            //check if the iteration arrived to the end of string
            if (index == S.length() - 1 && sequenceHasUpperCase && longestSequence.length() > lengthOfLongestSequence) {
                lengthOfLongestSequence = longestSequence.length();
                longestSequence = new StringBuilder();
                sequenceHasUpperCase = false;
            }
        }
        return lengthOfLongestSequence;
    }
}
