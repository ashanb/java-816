package stream.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReviewTester {
   public static void main(String[] args) {
      Stream<String> stream = Stream.iterate("", (s) -> s + "1");
      System.out.println(stream.limit(2).map(x -> x + "2"));

      System.out.println("----------2------------------------------------");

//      Predicate<? super String> predicate = s -> s.startsWith("g");
//      Stream<String> stream1 = Stream.generate(() -> "growl! ");
//      Stream<String> stream2 = Stream.generate(() -> "growl! ");
//      boolean b1 = stream1.anyMatch(predicate);
//      boolean b2 = stream2.allMatch(predicate);
//      System.out.println(b1 + " " + b2); // The code hangs.

      System.out.println("----------3------------------------------------");

      Predicate<? super String> predicate3 = s -> s.length() > 3;
      Stream<String> stream3 = Stream.iterate("-", (s) -> s + s);
      boolean b13 = stream3.noneMatch(predicate3);
      //boolean b23 = stream3.anyMatch(predicate3); // java.lang.IllegalStateException: stream has already been operated upon or closed
      //System.out.println(b13 + " " + b23);

      System.out.println("----------6------------------------------------");

      Stream<String> s = Stream.generate(() -> "meow");
      System.out.println(s.allMatch(String::isEmpty)); // false
      // boolean match = s.findFirst(String::isEmpty); // compile error
      // System.out.println(s.noneMatch(String::isEmpty)); // hangs
      // System.out.println(s.anyMatch(String::isEmpty)); // hangs
      // System.out.println(s.findAny(String::isEmpty)); // compile error

      System.out.println("----------7------------------------------------");

      List<String> stringList = new ArrayList<>();
      stringList.add("E");
      stringList.add("C");
      stringList.add("A");
      stringList.add("B");

      System.out.println(sort(stringList));
   }

   private static List<String> sort(List<String> list) {
      List<String> copy = new ArrayList<>(list);
      Collections.sort(copy, (a, b) -> b.compareTo(a)); // reverse order
      return copy;
   }

   private static List<String> sort2 (List<String> list) {
      return list.stream().sorted((a, b) -> b.compareTo(a))
              .collect(Collectors.toList());
   }
}
