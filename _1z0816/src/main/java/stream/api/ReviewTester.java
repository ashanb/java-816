package stream.api;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReviewTester {
   public static void main(String[] args) {
      Stream<String> stream = Stream.iterate("", (s) -> s + "1");
      System.out.println(stream.limit(2).map(x -> x + "2"));

      System.out.println("----------------------------------------------");

      Predicate<? super String> predicate = s -> s.startsWith("g");
      Stream<String> stream1 = Stream.generate(() -> "growl! ");
      Stream<String> stream2 = Stream.generate(() -> "growl! ");
      boolean b1 = stream1.anyMatch(predicate);
      boolean b2 = stream2.allMatch(predicate);
      System.out.println(b1 + " " + b2);
   }
}
