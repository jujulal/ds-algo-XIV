package treegraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * by prayagupd
 * on 3/27/15.
 *
 Design a hash table to store phone #s.
 Your job is to write a hash function that has a parameter username, and generate a key.
 Username is unique, length 5 and can be A-Z, 0-9, space.
 Write a hash function that generate keys without collisions and use minimum memory.

 * http://www.careercup.com/question?id=1927
 *
 * Further reading
 * Why does Java's hashCode() in String use 31 as a multiplier?(http://stackoverflow.com/a/299748/432903)
 */

class Patient {
  private String patientId;
  private int hashCode;

  public Patient(String patientId){
    this.patientId = patientId;
  }

  @Override
  public int hashCode(){
    int hash = hashCode;
    int baseMultiplier = 37;

//    int hash_[] = {hashCode};
//    int baseMultiplier_[] = {37};

    if (hash == 0 && this.patientId.length() > 0) {
//      //this.patientId.chars().forEach(System.out::println);
//      this.patientId.chars().mapToObj(i -> (char)i).forEach(character -> {
//        System.out.println(character);
//        int add = 0;
//        if (character >= 48 && character <= 57) { //fron index 1 to 9
//          add = character - 47;
//        } else if (character >= 65 && character <= 90) { //for AZ starting from 11 to 36
//          add = character - 54;
//        }
//        hash_[0] = add + (baseMultiplier_[0] * hash_[0]);
//        baseMultiplier_[0] *= baseMultiplier_[0];
//      });

      for (char character : this.patientId.toCharArray()) {
        int add = 0;
        if (character >= 48 && character <= 57) { //fron index 1 to 9
          add = character - 47;
        } else if (character >= 65 && character <= 90) { //for AZ starting from 11 to 36
          add = character - 54;
        }
        hash = add + (baseMultiplier * hash);
        baseMultiplier *= baseMultiplier;
      }
      hashCode = hash;
    }
    return hash;
  }

}

public class HashMapTests {
  public static void main(String[] args) {
    Map<Patient, String> map = new HashMap<Patient, String>(){{
      put(new Patient("ABC12"), "ABC12");
      put(new Patient("BAC21"), "BAC21");
    }};

    System.out.println(new Patient("ABC12").hashCode());
    System.out.println(new Patient("BAC21").hashCode());
    hashcodes();
    lambdaStreamMaths();
  }

  public static void hashcodes(){
    String Aa = new String("Aa");
    String BB = new String("BB");

    System.out.println(Aa.hashCode());
    System.out.println(BB.hashCode());
  }

  public static void lambdaStreamMaths(){
    final int base = 1;
    List<Double> costBeforeTax = Arrays.asList(100d, 200d, 300d, 400d, 500d);
    double bill = costBeforeTax.stream().map((eachValue) ->
                                               eachValue + Math.pow(base, 1) * eachValue)
                                        .reduce((sum, eachValue) ->
                                                sum + eachValue )
                                        .get();
    System.out.println("Total : " + bill);
  }
}


