package annotations;

import java.util.Arrays;
import java.util.List;

public class EnthuwareReCapTester {
   public static void main(String[] args) {

   }
   // Question T3 : Q3 Started
   @SafeVarargs
   static  void printElements(List<String>... la) {
      for (List<String> l : la) {
         System.out.println(l);
      }
   }
   // Question T3 : Q3 Ended
}
