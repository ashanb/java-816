package stream.api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Stream2IntermediateTester {
   public static void main(String[] args) {

      // 2. Common Intermediate Operations
      System.out.println("--------------------filter()");

      Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
      s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey

      System.out.println("\n--------------------distinct()");

      Stream<String> s1 = Stream.of("duck", "duck", "duck", "goose");
      s1.distinct().forEach(System.out::print); // duckgoose

      System.out.println("\n--------------------limit() and skip()");

      Stream<Integer> s2 = Stream.iterate(1, n -> n + 1);
      s2.skip(5).limit(2).forEach(System.out::print); // 67    (start from 6 and at 7)

      System.out.println("\n--------------------map()");

      Stream<String> s3 = Stream.of("monkey", "gorilla", "bonobo");
      s3.map(String::length).forEach(System.out::print); // 676

      System.out.println("\n--------------------flatMap()");

      List<String> zero = Arrays.asList();
      List<String> one = Arrays.asList("Bonobo");
      List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
      Stream<List<String>> animals = Stream.of(zero, one, two);
      animals.flatMap(l -> l.stream()).forEach(System.out::println);

      System.out.println("\n--------------------sorted()");

      Stream<String> s4 = Stream.of("brown-", "bear-");
      s4.sorted().forEach(System.out::print); // bear-brown

      Stream<String> s5 = Stream.of("brown bear-", "grizzly-");
      s5.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-

      System.out.println("\n--------------------peek()");

      Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
      long count = stream.filter(s6 -> s6.startsWith("g"))
              .peek(System.out::println).count(); // grizzly
      System.out.println(count); // 1
   }
}
