package concurrency.threadsafe;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
   private int sheepCount = 0;  // sometimes prints the same element, not thread safe

   private Object lock = new Object();

   // private AtomicInteger sheepCount2 = new AtomicInteger(0); // guarantees that it does not print the same thing
   private void incrementAndReport() {
      synchronized (lock) { // to preserve ordering.
         System.out.print((++sheepCount) + " ");
         printDaysWork(sheepCount);
      }
      //System.out.print(sheepCount2.incrementAndGet() + " ");
   }

   public static void printDaysWork(int sheepCount) {
      synchronized (SheepManager.class) {
         System.out.println("Finished work" + sheepCount);
      }
   }

   public static void main(String[] args) {
      ExecutorService service = null;
      try {
         service = Executors.newFixedThreadPool(100);
         SheepManager manager = new SheepManager();
         for (int i = 0; i < 10; i++)
            //synchronized (manager) {  // include order of calling, but this works only for thread creation, synchronized does not add big value.
            service.submit(() -> manager.incrementAndReport());
         // }
      } finally {
         if (service != null) service.shutdown();
      }
   }
}