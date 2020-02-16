package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ReviewTester {
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      System.out.println("--------------------------3");
      ExecutorService service = Executors.newSingleThreadScheduledExecutor();

//      service.scheduleWithFixedDelay(() -> { // w1 // changed
//         System.out.println("Open Zoo");
//         return null; // w2
//      }, 0, 1, TimeUnit.MINUTES);

//      Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
//
//      System.out.println(result.get()); // w4

      System.out.println("--------------------------4");

      AtomicLong value1 = new AtomicLong(0);
      final long[] value2 = {0};

      IntStream.iterate(1, i -> 1).limit(100).parallel()
      .forEach(i -> value1.incrementAndGet());

      IntStream.iterate(1, i -> 1).limit(100).parallel()
              .forEach(i -> ++value2[0]);
      System.out.println(value1+" "+value2[0]);
   }
}
