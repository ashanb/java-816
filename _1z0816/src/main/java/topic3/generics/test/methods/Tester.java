package topic3.generics.test.methods;

import topic3.generics.test.classes.Crate;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }
    public static <T> void sink(T t) { }

    public static <T> T identity(T t) { return t; }

    // public static String identity(String t) { return t + "E"; } // this method Get's the priority over T t

   //  public static T noGood(T t) { return t; } does not compile


    public static void printList(List<Object> list) {
        for (Object x: list) System.out.println(x);
    }

    public static void main(String[] args) {
        System.out.println(Tester.identity("X"));
        System.out.println(Tester.<String>identity("X")); // this works fine.

        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        // printList(keywords); // DOES NOT COMPILE


        List<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        // List<Object> objects = numbers; // DOES NOT COMPILE
        // objects.add("forty two");
        System.out.println(numbers.get(0));

        // List<Object> l = new ArrayList<String >(); Compile time

        Object[] o = new String[10];
        // o[0] = 1; /// Runtime Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer

        System.out.println(true);

        // ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE

        List<? extends Number> list = new ArrayList<Integer>();

        List<? extends Bird> birds = new ArrayList<Bird>();
        // birds.add(new Sparrow()); // DOES NOT COMPILE
        // birds.add(new Bird()); // DOES NOT COMPILE
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }

    static class Sparrow extends Bird {
    }

    static class Bird {
    }

    private void anyFlyer(List<Flyer> flyer) {}
    private void groupOfFlyers(List<? extends Flyer> flyer) {}
}
