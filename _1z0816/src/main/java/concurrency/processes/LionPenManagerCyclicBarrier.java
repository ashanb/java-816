package concurrency.processes;

import java.util.concurrent.*;

public class LionPenManagerCyclicBarrier {
   private void removeAnimals() { System.out.println("Removing animals"); }
   private void cleanPen() { System.out.println("Cleaning the pen"); }
   private void addAnimals() { System.out.println("Adding animals"); }
   public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
      try {
         removeAnimals();
         c1.await();
         cleanPen();
         c2.await();
         addAnimals();
      } catch (InterruptedException | BrokenBarrierException e) {
         // Handle checked exceptions here
      }
   }
   public static void main(String[] args) {
      ExecutorService service = null;
      try {
         service = Executors.newFixedThreadPool(4);
         LionPenManagerCyclicBarrier manager = new LionPenManagerCyclicBarrier();
         CyclicBarrier c1 = new CyclicBarrier(4);
         CyclicBarrier c2 = new CyclicBarrier(4,
                 () -> System.out.println("*** Pen Cleaned!"));
         for(int i=0; i<4; i++)
            service.submit(() -> manager.performTask(c1,c2));
      } finally {
         if(service != null) service.shutdown();
      }
   }
}