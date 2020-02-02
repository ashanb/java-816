package concurrency.executor.service;

import java.util.concurrent.*;

public class ScheduledTaskTester {
   public static void main(String[] args) {
      final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
      final Runnable task1 = () -> System.out.println("Hello Zoo");
      final Callable<String> task2 = () -> "Monkey";

      final Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
      final Future<?> result2 = service.schedule(task2, 8, TimeUnit.MINUTES);


       service.scheduleAtFixedRate(task1,5,1,TimeUnit.MINUTES); // take only runnable

       service.scheduleWithFixedDelay(task1,0,2,TimeUnit.MINUTES); // take only runnable

   }
}
