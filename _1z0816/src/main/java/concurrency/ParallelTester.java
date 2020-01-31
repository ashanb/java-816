/*
 *                 IFS Research & Development
 *
 *  This program is protected by copyright law and by international
 *  conventions. All licensing, renting, lending or copying (including
 *  for private use), and all other use of the program, which is not
 *  expressively permitted by IFS Research & Development (IFS), is a
 *  violation of the rights of IFS. Such violations will be reported to the
 *  appropriate authorities.
 *
 *  VIOLATIONS OF ANY COPYRIGHT IS PUNISHABLE BY LAW AND CAN LEAD
 *  TO UP TO TWO YEARS OF IMPRISONMENT AND LIABILITY TO PAY DAMAGES.
 */
package concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Ashan
 */

// Youtube video test: https://www.youtube.com/watch?v=x5akmCWgGY0
public class ParallelTester {
   public static int doubleInt(int n) {
      try {
         Thread.sleep(100);
         System.out.println(Thread.currentThread().getName() + " with n = " + n);
      } catch (InterruptedException ignore) {
         //
      }
      return n * 2;
   }

   // Convert2streamapi
   public static void main(String[] args) {
      List<Integer> ints = Arrays.asList(3, 1, 4, 1, 5, 9);

      // Non-Functional, with shared mutable state.
      int total = 0;

      for (int i : ints) {
         total += i;
      }
      System.out.println("Total = " +total);

      total = IntStream.of(3, 1, 4, 1, 5, 9, 2, 6).sum();

      System.out.println("Total = " +total);

      System.out.println("------------------------");

      Instant before = Instant.now();

      total = IntStream.of(3, 1, 4, 1, 5, 9)
              .parallel() // if  commented sequential
              .map(ParallelTester::doubleInt) // same as i -> doubleInt(i)
              .sum();

      Instant after = Instant.now();

      Duration duration = Duration.between(before, after);

      System.out.println("------------------------");
      System.out.println("Total of doubles = " + total);
      System.out.println("time = " + duration.toMillis() + " ms");
   }
}
