package concurrency.parallel.streams;

import java.util.*;

public class WhaleDataCalculator {
   public int processRecord(int input) {
      try {
         System.out.println("hit:" + input);
         Thread.sleep(10);
      } catch (InterruptedException e) {
         // Handle interrupted exception
      }
      return input + 1;
   }

   public void processAllData(List<Integer> data) {
      long total = data.stream().map(a -> {
         System.out.println("Call Me"); // does not get called.
         return processRecord(a);
      }).count();

      //long total = data.parallelStream().map(a -> processRecord(a)).count();

      System.out.println(total);
   }

   public static void main(String[] args) {
      final WhaleDataCalculator calculator = new WhaleDataCalculator();
      // Define the data
      final List<Integer> data = new ArrayList<Integer>();
      for (int i = 0; i < 4000; i++) {
         data.add(i);
         //System.out.println(i);
      }
      // Process the data
      final long start = System.currentTimeMillis();
      calculator.processAllData(data);
      final double time = (System.currentTimeMillis() - start) / 1000.0;
      // Report results
      System.out.println("\nTasks completed in: " + time + " seconds");
   }
}
