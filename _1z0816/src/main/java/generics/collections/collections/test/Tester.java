package generics.collections.collections.test;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Tester implements Serializable {
    public static void main(String[] args) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        ////////////////////////////////////
        // Collections
        // List

        // Add
        List<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow")); // true

        // Remove
        List<String> birds1 = new ArrayList<>();
        birds1.add("hawk"); // [hawk]
        birds1.add("hawk"); // [hawk, hawk]
        System.out.println(birds1.remove("cardinal")); // prints false
        System.out.println(birds1.remove("hawk")); // prints true
        System.out.println(birds1); // [hawk]

        // isEmpty() , size()
        System.out.println(birds1.isEmpty()); // true
        System.out.println(birds1.size()); // 0

        birds1.add("hawk"); // [hawk]
        birds1.add("hawk"); // [hawk, hawk]
        System.out.println(birds1.isEmpty()); // false
        System.out.println(birds1.size()); // 2

        // Clear
        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk"); // [hawk]
        birds2.add("hawk"); // [hawk, hawk]
        System.out.println(birds2.isEmpty()); // false
        System.out.println(birds2.size()); // 2
        birds2.clear(); // []
        System.out.println(birds2.isEmpty()); // true
        System.out.println(birds2.size()); // 0

        // Contains // true This method calls equals() on each element of the ArrayList to see if there are any matches.
        List<String> birds3 = new ArrayList<>();
        birds3.add("hawk"); // [hawk]
        System.out.println(birds3.contains("hawk"));
        System.out.println(birds3.contains("robin")); // false

        // All in one

        List<String> list1 = new ArrayList<>();
        list1.add("SD"); // [SD]
        list1.add(0, "NY"); // [NY,SD]
        list1.set(1, "FL"); // [NY,FL]
        list1.remove("NY"); // [FL]
        list1.remove(0); // []

/*        Iterator<String> iter = list.iterator();  java 1.5 // Intellij convert this to below enhanced for loop
        while(iter.hasNext()) {
            String string = iter.next();
            System.out.println(string);
        }*/

        for (String string : list1) {
            System.out.println(string);
        }

        // Set

        final Set<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); // true
        System.out.println(set.add("Sparrow")); // false

        System.out.println("--------- Hash SET");

        final Set<Integer> set1 = new HashSet<>();
        boolean b1 = set1.add(66); // true
        boolean b2 = set1.add(10); // true
        boolean b3 = set1.add(66); // false
        boolean b4 = set1.add(8); // true
        for (Integer integer: set1) System.out.print(integer + ","); // 66,8,10,
        System.out.println("\n--------- Tree SET");

        Set<Integer> set2 = new TreeSet<>();
        boolean b12 = set2.add(66); // true
        boolean b22 = set2.add(10); // true
        boolean b32 = set2.add(66); // false
        boolean b42 = set2.add(8); // true
        for (Integer integer2: set2) System.out.print(integer2 + ","); // 8,10,66

        System.out.println("\n--------- NavigableSet Tree SET");
        NavigableSet<Integer> set3 = new TreeSet<>();

        for (int i = 1; i <= 20; i++) set3.add(i);
        System.out.println(set3.lower(10)); // 9
        System.out.println(set3.floor(10)); // 10
        System.out.println(set3.ceiling(20)); // 20
        System.out.println(set3.higher(20)); // null

        // Queue

        System.out.println("\n--------- Queue");

        // "offer" adds an element back of the queue.
        // "push" adds an element front of the queue.
        // "peek" Returns next element or returns null if empty queue
        // "pool" Removes and returns next element or returns null if empty queue

        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null

        // Stack

        // "pop" removes and returns next element or throws an exception if empty queue

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek()); // 4
        System.out.println(stack.poll()); // 4
        System.out.println(stack.poll()); // 10
        System.out.println(stack.peek()); // null

        // Map

        System.out.println("\n--------- Hash Map");

        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key: map.keySet())
            System.out.print(key + ","); // koala,giraffe,lion,

        System.out.println("\n--------- Tree Map");

        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        String food2 = map2.get("koala"); // bamboo
        for (String key: map2.keySet())
            System.out.print(key + ","); // giraffe,koala,lion,

        // System.out.println(map2.contains("lion")); // DOES NOT COMPILE
        System.out.println(map2.containsKey("lion")); // true
        System.out.println(map2.containsValue("lion")); // false
        System.out.println(map2.size()); // 3

    }
}
