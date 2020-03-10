package concurrency.collections;

import java.util.*;
import java.util.concurrent.*;

public class ZooManager {
   private Map<String, Object> foodData = new HashMap<String, Object>();

   public synchronized void put(String key, String value) {
      foodData.put(key, value);
   }

   public synchronized Object get(String key) {
      return foodData.get(key);
   }
}

class ConcurrentCollectedZooManager {
   private Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();

   public void put(String key, String value) {
      foodData.put(key, value);
   }

   public Object get(String key) {
      return foodData.get(key);
   }

   public static void main(String[] args) {
//      Map<String, Object> foodData = new HashMap<String, Object>();
//      foodData.put("penguin", 1);
//      foodData.put("flamingo", 2);
//      for(String key: foodData.keySet())
//         foodData.remove(key);  // java.util.ConcurrentModificationException

      // concurrent collections

      System.out.println("---------------------- ConcurrentHashMap 1");

      Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
      foodData.put("penguin", 1);
      foodData.put("flamingo", 2);
      foodData.put("flamingo2", 3);
      for (Map.Entry e : foodData.entrySet()) { // time that it created
         Object key = e.getKey();
         Object value = e.getValue();
         foodData.remove(e.getKey());
         foodData.put(key.toString(), value);
         System.out.println(e.getValue()); // returns null
      }

      System.out.println("Size `= " + foodData.size()); // returns null

      System.out.println("---------------------- ConcurrentHashMap 2");

      Map<String, Integer> map = new ConcurrentHashMap<>();
      map.put("zebra", 52);
      map.put("elephant", 10);

      System.out.println(map.get("elephant"));

      System.out.println("---------------------- ConcurrentLinkedQueue");

      Queue<Integer> queue = new ConcurrentLinkedQueue<>();
      queue.offer(31);

      System.out.println(queue.peek());
      System.out.println(queue.poll());

      System.out.println("---------------------- ConcurrentLinkedDeque");

      Deque<Integer> deque = new ConcurrentLinkedDeque<>();
      deque.offer(10);
      deque.push(4);

      System.out.println(deque.peek());
      System.out.println(deque.pop());

      System.out.println("---------------------- ArrayDeque");

      Deque<Integer> d = new ArrayDeque<>();
      d.push(1);
      d.push(2);
      d.push(3);
      System.out.println(d.remove());
      System.out.println(d.remove());
      System.out.println(d.remove());

      System.out.println("---------------------- LinkedBlockingQueue");
      try {
         BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
         blockingQueue.offer(39);
         blockingQueue.offer(3, 4, TimeUnit.SECONDS);
         System.out.println(blockingQueue.poll());
         System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
      } catch (InterruptedException e) {
         // Handle interruption
      }

      System.out.println("---------------------- LinkedBlockingDeque");
      try {
         BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
         blockingDeque.offer(91);
         blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
         blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
         blockingDeque.offer(3, 4, TimeUnit.SECONDS);
         System.out.println(blockingDeque.poll());
         System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
         System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
         System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
      } catch (InterruptedException e) {
         // Handle interruption
      }
      System.out.println("---------------------- CopyOnWriteArrayList");

      List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
      for (Integer item : list) {
         System.out.print(item + " ");
         list.add(9);
      }
      System.out.println();
      System.out.println("Size: " + list.size());

//      System.out.println("---------------------- HashMap with synchronizedMap");
//
//      Map<String, Object> foodData2 = new HashMap<String, Object>();
//      foodData2.put("penguin", 1);
//      foodData2.put("flamingo", 2);
//      Map<String,Object> synchronizedFoodData = Collections.synchronizedMap(foodData2);
//      for(String key: synchronizedFoodData.keySet())
//         synchronizedFoodData.remove(key); // java.util.ConcurrentModificationException
   }

}

