package fundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class VCEGuideTester {
}

class Vehicle {
   int id;
   public void start() {
       // public class Engine { // public modifier not allowwd

      //}
   }
}

class Computer {
   static int cost;
   public Computer(int cost) {
      this.cost = cost;
   }

   private Card card = new SoundCard();   // Working
   private abstract class Card {};
   private class SoundCard extends Card {};

   public static void main(String[] args) {

   }
}

class Block {
   int bno;
   static class Counter {
      int locator;
      Counter() {
         //locator = bno; // does not compile bno needs to static
      }
   }
}

class Product {
   interface Movable {
      void move();
   }
   Movable mProduct = new Movable() {
      //@Override
      public void move() { // public needs to be there.
      }
   };
}

@FunctionalInterface
interface P {
   public void method1();
}

@FunctionalInterface
interface Q extends P {
   public void method1();
}

//@FunctionalInterface
//interface R extends P {
//   public void method2();
//}

//@FunctionalInterface
//interface s {
//   public default void method1(){};
//}

//@FunctionalInterface
//interface T {
//   public void method1();
//   public void method2();
//}

//@FunctionalInterface
//interface T {
//   public void method1();
//   public abstract void method2();
//}

class ProductCode<T, S extends T> {
   T c1;
   S c2;

   public static void main(String[] args) {
      ProductCode<Number, Integer> c1 = new ProductCode<Number, Integer>();

      //ProductCode<Number, String> c2 = new ProductCode<Number, String>();
   }
}

class Foo<K, V> {
   private K key;

   public Foo(K key, V value) {
      this.key = key;
      this.value = value;
   }

   private V value;

   public K getKey() {
      return key;
   }

   public void setKey(K key) {
      this.key = key;
   }

   public V getValue() {
      return value;
   }

   public void setValue(V value) {
      this.value = value;
   }

   public static <T> Foo<T,T> twice(T value) {
      return new Foo<T, T> (value, value);
   }

   public static void main(String[] args) {
//      // Foo<Object, Object> foo = new Foo<String, String>("John", "A"); // does not compile.
//      Foo<String, String> foo = new Foo<>("John", "A"); // ok
//
//      Predicate<String> predicate = (String s) -> s.length() >3;


//      List<String> cs = Arrays.asList("Java EE", "Java", "Java ME");
//      boolean b = cs.stream().allMatch(w ->w.equals("Java"));
//      System.out.println(b);

//      final String str1 = "Java";
//
//      StringBuffer stringBuffer = new StringBuffer("Course");
//      UnaryOperator<String> u  = (str2) -> str1.concat(str2);
//      UnaryOperator<String> c  = (str3) -> str3.toLowerCase();

      //System.out.println(u.apply(c.apply(stringBuffer)));

//      Foo<String, Integer> mark = new Foo<String, Integer> ("Steve", 100););
//      Foo<String, String> pair = Foo.<String>twice ("Hello World!");
//      Foo<?, ?> percentage = new Foo <> (97, 32);
//      Foo<String, String> grade = new Foo <> ("John", "A");
   }

   public void start(){
      double d = 0;
      assert d > 0:"";

   }
}

enum Color
{
   RED (100) {
      void abstractInfo(){};
   };
   // enum constructor called separately for each
   // constant
   // Every enum constant is always implicitly public static final.

   private int cost1;
  // private static int cost2;
   Color(int i)   // constructor is private
   {
      //this.cost2=i;  // can not set inside the constructor
   }

   int colorInfo()
   {
      System.out.println("Universal Color");
      return cost1;
   }

   abstract void abstractInfo();
}

class Test
{
   // Driver method
   public static void main(String[] args)
   {
      Color c1 = Color.RED;
      c1.colorInfo();
      System.out.println(c1);
      c1.colorInfo();

      for (Color color : Color.values()) {
         System.out.println(color + "Fees " + color.colorInfo());
      }
   }
}

class Resource implements  AutoCloseable {

   public void open() throws Exception {
      System.out.println("open-");
   }

   @Override
   public void close() throws Exception {
      System.out.println("close-");
   }

   public static void main(String[] args) {
      Resource resource = new Resource();

      try {
         resource.open();
         resource.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      try (resource) {   // this is ok.
            resource.open();
      } catch (Exception e) {
         e.printStackTrace();
      }

//      try (resource = new Resource();) {
//         resource.open();
//      } catch (Exception e) {
//         e.printStackTrace();
//      }

   }
}

class Job {
   String name;
   Integer cost;

   public Job(String name, Integer cost) {
      this.name = name;
      this.cost = cost;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getCost() {
      return cost;
   }

   public void setCost(Integer cost) {
      this.cost = cost;
   }

   public static void main(String[] args) {
//      Job j1 = new Job("IT", null);
////
////      DoubleSupplier js1 = j1::getCost;
////
////      System.out.println(j1.getName() + ":" + js1.getAsDouble());

      // CourseFilter courseFilter = n -> n.contains("Java");

      CourseFilter courseFilter = new CourseFilter() {
         public boolean test(String s) {
            return s.contains("Java");
         }
      };
      System.out.println(courseFilter.Test("Java"));
   }
}

interface CourseFilter extends Predicate<String> {
   default boolean Test (String str) {
      return str.equals("Java1");
   }
}



