package concurrency.processes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Worker extends Thread {
   CyclicBarrier cb;
   public Worker(CyclicBarrier cb) { this.cb = cb; }
   public void run () {
      try {
         cb.await();
         System.out.println("Worker…");
      } catch (Exception ex) { }
   }
}
class Master implements Runnable { //line n1
   public void run () {
      System.out.println("Master…");
   }

   public static void main(String[] args) {
//      Master master = new Master();
//      CyclicBarrier cb = new CyclicBarrier(1, master);
//      Worker worker = new Worker(cb);
//      worker.start();
//      Stream<List<String>> strs = Stream.of(Arrays.asList("text1", "text2"), Arrays.asList("text3", "text4"));
//
//      strs.filter(f -> f.contains("text1")).flatMap(fl->fl.stream()).forEach(System.out::print); // text1text2
//
//      DoubleStream str = DoubleStream.of (1.0, 2.0, 3.0, 4.0);

      IntConsumer consumer = e -> System.out.println(e);

      Integer value = 90;

      // Function<Integer, Integer> funRef = e -> e + 10;

      // UnaryOperator<Integer> funRef = e -> e + 10;
      // IntFunction<Integer> funRef = e -> e + 10;
      //Integer result = funRef.apply(value);

      ToIntFunction<Integer> funRef = e -> e + 10;
      Integer result = funRef.applyAsInt(value);

      consumer.accept(result);

   }
}