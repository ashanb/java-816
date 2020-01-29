package generics.collections.comparable.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest1 {
}

class Dog implements Comparable<Dog> {
    private String name;
    private int weight;

    public Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Dog d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
//        Comparator<Dog> byWeight = new Comparator<Dog>() {  // compare implementation (dynamic)
//            public int compare(Dog d1, Dog d2) {
//                return (d1.getWeight() - d2.getWeight());
//            }
//        };

        Comparator<Dog> byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight();   // All do the same thing
//        Comparator<Dog> byWeight = (Dog d1, Dog d2) -> d1.getWeight() - d2.getWeight();
//        Comparator<Dog> byWeight = (d1, d2) -> { return d1.getWeight() - d2.getWeight(); };
//        Comparator<Dog> byWeight = (Dog d1, Dog d2) -> {return d1.getWeight() -d2.getWeight(); };

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Quack", 7));
        dogs.add(new Dog("Puddles", 10));

        Collections.sort(dogs); // calling the comparable interface compare to
        System.out.println(dogs); // [Puddles, Quack]
        Collections.sort(dogs, byWeight); // calling for the comparator compare implementation
        System.out.println(dogs); // [Quack, Puddles]
    }
}