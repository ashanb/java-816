package stream.api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectingResults {
   public static void main(String[] args) {

      System.out.println("----------------Collecting Using Basic Collectors");

      final Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
      final String result = ohMy.collect(Collectors.joining(", "));
      System.out.println(result); // lions, tigers, bears

      final Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
      final Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
      System.out.println(result2); // 5.333333333333333

      Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
      TreeSet<String> result3 = ohMy3.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
      System.out.println(result); // [tigers]

      System.out.println("----------------Collecting into Maps");

      Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
      Map<String, Integer> map1 = ohMy4.collect(
              Collectors.toMap(s -> s, String::length));
      System.out.println(map1); // {lions=5, bears=5, tigers=6}

      Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
      //Map<Integer, String> map2 = ohMy5.collect(Collectors.toMap(String::length, k -> k)); // BAD // exception

      Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears");
      Map<Integer, String> map3 = ohMy6.collect(Collectors.toMap(
              String::length, k -> k, (s1, s2) -> s1 + "," + s2));
      System.out.println(map3); // {5=lions,bears, 6=tigers}
      System.out.println(map3.getClass()); // class. java.util.HashMap

      Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
      TreeMap<Integer, String> map4 =
              ohMy7.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
      System.out.println(map4); // // {5=lions,bears, 6=tigers}
      System.out.println(map4.getClass()); // class. java.util.TreeMap

      System.out.println("------------Collecting Using Grouping, Partitioning, and Mapping");

      Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
      Map<Integer, List<String>> map5 = ohMy8.collect(
              Collectors.groupingBy(String::length));
      System.out.println(map5); // {5=[lions, bears], 6=[tigers]}

      Stream<String> ohMy9 = Stream.of("lions", "tigers", "bears");
      Map<Integer, Set<String>> map6 = ohMy9.collect(
              Collectors.groupingBy(String::length, Collectors.toSet()));
      System.out.println(map6); // {5=[lions, bears], 6=[tigers]}

      Stream<String> ohMy10 = Stream.of("lions", "tigers", "bears");
      TreeMap<Integer, Set<String>> map7 = ohMy10.collect(
              Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
      System.out.println(map7); // {5=[lions, bears], 6=[tigers]}

      Stream<String> ohMy11 = Stream.of("lions", "tigers", "bears");
      TreeMap<Integer, List<String>> map8 = ohMy11.collect(
              Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
      System.out.println(map8);

      Stream<String> ohMy12 = Stream.of("lions", "tigers", "bears");
      Map<Boolean, List<String>> map9 = ohMy12.collect(
              Collectors.partitioningBy(s -> s.length() <= 5));
      System.out.println(map9); // {false=[tigers], true=[lions, bears]}

      Stream<String> ohMy13 = Stream.of("lions", "tigers", "bears");
      Map<Boolean, List<String>> map10 = ohMy13.collect(
              Collectors.partitioningBy(s -> s.length() <= 7));
      System.out.println(map10); // {false=[], true=[lions, tigers, bears]}

      Stream<String> ohMy14 = Stream.of("lions", "tigers", "bears");
      Map<Boolean, Set<String>> map11 = ohMy14.collect(
              Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
      System.out.println(map11);// {false=[], true=[lions, tigers, bears]}

      Stream<String> ohMy15 = Stream.of("lions", "tigers", "bears");
      Map<Integer, Long> map12 = ohMy15.collect(Collectors.groupingBy(
              String::length, Collectors.counting()));
      System.out.println(map12); // {5=2, 6=1}

//      Stream<String> ohMy16 = Stream.of("lions", "tigers", "bears");
//      Map<Integer, Optional<Character>> map13 = ohMy.collect(
//              Collectors.groupingBy(
//                      String::length,
//                      Collectors.mapping(s -> s.charAt(0),
//                              Collectors.minBy(Comparator.naturalOrder()))));
//      System.out.println(map13); // {5=Optional[b], 6=Optional[t]}
//
//      Stream<String> ohMy17 = Stream.of("lions", "tigers", "bears");
//      Map<Integer, Optional<Character>> map14 =
//              ohMy17.collect(Collectors.groupingBy(
//                      String::length, Collectors.mapping(
//                              s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
//      System.out.println(map14); // {5=Optional[b], 6=Optional[t]}
   }
}
