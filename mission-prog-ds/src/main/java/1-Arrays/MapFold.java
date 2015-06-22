import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * /**
 * Given a list of facebook users, and their activities
 * Find if each facebook user has more comments than likes,
 *
 * eg. data
 * ["A" -> ("like", "comment", "like", "comment", "like") ]
 *
 * Created by prayagupd
 * on 4/29/15.
 */

class Mappper {
  public int map(String x) { return  (x.equals("like")) ? 1 : -1; }
}

class Folder {
  public int fold(int x, int y) {
    return x + y;
  }
}

public class MapFold {
  public static void main(String[] args) {
    final Map<String, List<String>> jsonData = new HashMap<String, List<String>>(){{
      put("prayag upd",    Arrays.asList("like", "comment", "like", "like", "comment"));
      put("steven wilson", Arrays.asList("like", "comment", "like", "comment", "like", "comment"));
    }};

    //map

    jsonData.forEach((index, value) -> {
      final List<String> json = jsonData.get(index);
      int[] mapResultArray = new int[json.size()];
      IntStream.range(0, json.size()).forEach(i -> {
        mapResultArray[i] = new Mappper().map(json.get(i));
        System.out.println(json.get(i) + " => " + mapResultArray[i]);
      });

      //fold
      int[] foldResultArray = new int[json.size()];
      int[] initialState = {0};
      IntStream.range(0, json.size()).forEach(i -> {
        initialState[0] = new Folder().fold(initialState[0], mapResultArray[i]);
        foldResultArray[i] = initialState[0];

      });

      //interpretation
      if (initialState[0] > 0) {
        System.out.println("User " + index + " has more likes.");
      } else if (initialState[0] < 0) {
        System.out.println("User " + index + " has more comments.");
      } else {
        System.out.println("User " + index + " equal likes and comments.");
      }
    });
  }
}
