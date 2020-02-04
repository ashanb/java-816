package stream.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsAdvancedConcepts {
   public static void main(String[] args) {
      // not for the exam
      List<String> cats = new ArrayList<>();
      cats.add("Annie");
      cats.add("Ripley");

      Stream<String> stream = cats.stream();
      cats.add("KC");
      System.out.println(stream.count());
   }

   // Chaining Optionals
   private static void threeDigit(Optional<Integer> optional) {
      if (optional.isPresent()) { // outer if
         Integer num = optional.get();
         String string = "" + num;
         if (string.length() == 3) // inner if
            System.out.println(string);
      }

      // with functional programming
      optional.map(n -> "" + n) // part 1
              .filter(s -> s.length() == 3) // part 2
              .ifPresent(System.out::println); // part 3
   }
}
