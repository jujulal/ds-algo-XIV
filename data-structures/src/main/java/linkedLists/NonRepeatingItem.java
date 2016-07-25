package linkedLists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by prayagupd
 * on 7/10/16.
 */

public class NonRepeatingItem {

    List<Character> nonRepeatingChars = new LinkedList<>(); // O(n) space
    int[] repeated = new int[256];    // O(n) space

    public NonRepeatingItem() {
        IntStream.range(0, 256).forEach( index -> { //O(n)
            repeated[index] = 0;
        });
    }

    public Character getFirstNonRepeating(Character character) {

        if (repeated[character] == 0) {
            repeated[character]++;
            nonRepeatingChars.add(character); // O()
        } else {
            repeated[character]++;
            nonRepeatingChars.remove(character);
        }

        return nonRepeatingChars.get(0);
    }
}
