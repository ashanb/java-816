package generics.collections.gen.test.complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class EnthuwareReCapTester {
   static class Sparrow extends Bird { }
   static class Bird { }

   public static void test (List<? extends Bird> list) { // upper bound
      // list.add(new Sparrow()) does not compile.
      System.out.println(list.stream().count());
   }

   public static void addSound(List<? super Number> list) {       // lower bound
      list.add(1);
      list.add(1.2);
      
      System.out.println(list.size());
   }

   public static void main(String[] args) {
/*      List<?> numbers = new ArrayList<Integer>(); // working
//      List<?> strings = new ArrayList<String>();
      strings = numbers;*/

      //List<? extends Bird> birds = new ArrayList<Bird>();

      List<? extends Bird> birds = new ArrayList<Sparrow>();

      // birds.add(new Sparrow()); // DOES NOT COMPILE
      // birds.add(new Bird()); // DOES NOT COMPILE

      List<Sparrow> sparrows = Arrays.asList(new Sparrow(), new Sparrow());
      test(sparrows);

//      List<? super String> list = new ArrayList<>();
//      list.add("quack");

      List<Object> list = new ArrayList<>();
      list.add(new Object());
      List<Integer> list2 = new ArrayList<>();
      addSound(list);
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
