package concurrency.parallel.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParallelTester {
   public static void main(String[] args) {
//      System.out.println("-------------------------- Serial Streams");
//      Arrays.asList(1, 2, 3, 4, 5, 6)
//              .stream()
//              .forEach(s -> System.out.print(s + " "));
//
//      System.out.println("\n-------------------------- Parallel Streams");
//      Arrays.asList(1, 2, 3, 4, 5, 6)
//              .parallelStream()
//              .forEach(s -> System.out.print(s + " "));


      final List<String> list = new ArrayList<>();
      for(int i =0; i< 10000000; i++) {
         list.add("Hello" + i);
      }

      final long start = System.currentTimeMillis();

      list.stream().map(s -> s.toUpperCase()).forEach(System.out::println); // 10000000 Time to Process: 50.792  // Fck Me! :/

      //list.parallelStream().map(s -> s.toUpperCase()).forEach(System.out::println); // 10000000  Time to Process: 75.442

      final double time = (System.currentTimeMillis() - start) / 1000.0;

      System.out.println("Time to Process: " + time);


//      List<Integer> data = Collections.synchronizedList(new ArrayList<>()); // this should be synchronized otherwise strong.
//      Arrays.asList(1,2,3,4,5,6).parallelStream()
//              .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
//              .forEachOrdered(i -> System.out.print(i+" "));
//      System.out.println();
//      for(Integer e: data) {
//         System.out.print(e+" ");
//      }
   }
}
