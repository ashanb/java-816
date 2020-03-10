package annotations;

import java.util.ArrayList;
import java.util.List;

public class ReviewTester {
}

class TestClass {

   public static void main(String... args) throws Exception {
      List<Integer> al = new ArrayList<Integer>();
      printElements(al);
   }

   @SafeVarargs
   static void printElements(List<Integer>... la) {
      for (List<Integer> l : la) {
         System.out.println(l);
      }
   }
}
