package topic3.comparable.comparator;

import java.util.*;


public class Tester {
    static class Rabbit{ int id; }
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder(); // reverse ordering
        int index = Collections.binarySearch(names, "Hoppy", c); // -1
        System.out.println(index);

        Set<Duck> ducks = new TreeSet<>();   // sorted set due to Tree set:)
        ducks.add(new Duck("Puddles"));
        Set<Rabbit> rabbit = new TreeSet<>();
        // rabbit.add(new Rabbit()); // throws an runtime exception


        Comparator<Rabbit> c2 = new Comparator<Rabbit>() {
            public int compare(Rabbit r1, Rabbit r2) {
                return r1.id = r2.id;
            }
        };
        Set<Rabbit> rabbit2 = new TreeSet<>(c2); // Alternatively at creation time set the comparator.
        rabbit2.add(new Rabbit());
    }
}
