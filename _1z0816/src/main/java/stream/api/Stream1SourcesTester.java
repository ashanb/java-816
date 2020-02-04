package stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream1SourcesTester {
   public static void main(String[] args) {
      Stream<String> empty0 = Stream.empty(); // count = 0
      Stream<Integer> singleElement = Stream.of(1); // count = 1
      Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 2

      List<String> list0 = Arrays.asList("a", "b", "c");
      Stream<String> fromList = list0.stream();
      Stream<String> fromListParallel = list0.parallelStream();

      // 1. Stream Sources

      System.out.println("--------------------count()");

      Stream<String> s0 = Stream.of("monkey", "gorilla", "bonobo");
      System.out.println(s0.count()); // 3

      System.out.println("\n--------------------min() and max()");

      Stream<String> s11 = Stream.of("monkey", "ape", "bonobo");
      Optional<String> min = s11.min((s1, s2) -> s1.length() - s2.length());
      min.ifPresent(System.out::println); // ape

      Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
      System.out.println(minEmpty.isPresent()); // false

      System.out.println("\n--------------------findAny() and findFirst()");

      Stream<String> s2 = Stream.of("monkey", "gorilla", "bonobo");
      Stream<String> infinite0 = Stream.generate(() -> "chimp");
      s2.findAny().ifPresent(System.out::println); // monkey
      infinite0.findAny().ifPresent(System.out::println); // chimp

      System.out.println("\n--------------------allMatch() , anyMatch() and noneMatch()");

      List<String> list = Arrays.asList("monkey", "2", "chimp");
      Stream<String> infinite = Stream.generate(() -> "chimp");
      Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
      System.out.println(list.stream().anyMatch(pred)); // true
      System.out.println(list.stream().allMatch(pred)); // false
      System.out.println(list.stream().noneMatch(pred)); // false
      System.out.println(infinite.anyMatch(pred)); // true

      System.out.println("\n--------------------forEach()");

      Stream<String> s3 = Stream.of("Monkey", "Gorilla", "Bonobo");
      s3.forEach(System.out::print); // MonkeyGorillaBonobo

      Stream s = Stream.of(1);
      // for (Integer i: s) {} // DOES NOT COMPILE


      System.out.println("\n--------------------reduce()");

      String[] array = new String[] { "w", "o", "l", "f" };
      String result = "";
      for (String string: array) result = result + s;
      System.out.println(result);

      Stream<String> stream = Stream.of("w", "o", "l", "f");
      String word = stream.reduce("", (s6, c) -> s6 + c);
      System.out.println(word); // wolf

      Stream<String> stream2 = Stream.of("w", "o", "l", "f");
      String word1 = stream2.reduce("", String::concat);
      System.out.println(word1); // wolf

      Stream<Integer> stream1 = Stream.of(3, 5, 6);
      System.out.println(stream1.reduce(1, (a, b) -> a*b));

      BinaryOperator<Integer> op = (a, b) -> a * b;
      Stream<Integer> empty = Stream.empty();
      Stream<Integer> oneElement = Stream.of(3);
      Stream<Integer> threeElements = Stream.of(3, 5, 6);

      empty.reduce(op).ifPresent(System.out::print); // no output
      oneElement.reduce(op).ifPresent(System.out::print); // 3
      threeElements.reduce(op).ifPresent(System.out::print); // 90

      BinaryOperator<Integer> op1 = (a, b) -> a * b;
      Stream<Integer> stream3 = Stream.of(3, 5, 6);
      System.out.println(stream3.reduce(1, op1, op1)); // 90

      System.out.println("\n--------------------collect()");

      Stream<String> stream4 = Stream.of("w", "o", "l", "f");
      StringBuilder word2 = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);


      Stream<String> stream5 = Stream.of("w", "o", "l", "f");
      TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add,
              TreeSet::addAll);
      System.out.println(set); // [f, l, o, w]
   }
}
