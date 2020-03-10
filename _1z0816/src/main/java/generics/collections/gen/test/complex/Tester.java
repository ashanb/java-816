package generics.collections.gen.test.complex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A {
}

class B extends A {
}

class B2 extends A {
}

class C extends B {
}

public class Tester {
   static class BabySparrow extends Sparrow {
   }

   static class Sparrow extends Bird {
   }

   static class Bird extends Fly {
   }

   static class Fly {
   }


   public static void main(String[] args) {
      List<?> list1 = new ArrayList<A>();
      List<? extends A> list2 = new ArrayList<A>();
      List<? super A> list3 = new ArrayList<A>();
      // List<? super A> list32 = new ArrayList<B>(); // DOES NOT COMPILE

      // List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
      List<? super B> list5 = new ArrayList<A>();

      List<? super B> list52 = new ArrayList<A>();
      list52.add(new C());

      List<? super B> list53 = Arrays.asList(new A());
      //list53.add(new C());

      // List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE


      List<? extends Bird> birds = Arrays.asList(new Sparrow(), new Bird());

      // immutable list, can not add FUCK!!
      // birds.add(new BabySparrow()); // DOES NOT COMPILE
      // birds.add(new Sparrow()); // DOES NOT COMPILE
      // birds.add(new Sparrow()); // DOES NOT COMPILE
      // birds.add(new Bird()); // DOES NOT COMPILE

      List<? super IOException> exceptions = new ArrayList<>();
      // exceptions.add(new Exception()); // DOES NOT COMPILE (No logical explanation)

      // exceptions.add(new Object()); // DOES NOT COMPILE (No logical explanation)
      exceptions.add(new IOException());
      exceptions.add(new FileNotFoundException());
   }

   <T> T method1(List<? extends T> list) {
      return list.get(0);
   }

   /* <T> <? extends T> method2(List<? extends T> list) { // DOES NOT COMPILE <? extends T>  =>>> T
        return list.get(0);
    }*/

/*    <B extends A> B method3(List<B> list) {
        return new B(); // DOES NOT COMPILE
    }*/

   <T extends A> B method3(List<T> list) {   // Not properly understood!
      return new B();
   }

   void method4(List<? super B> list) {
   }

//    <X> void method5(List<? super B> list) { // DOES NOT COMPILE }

   <X> void method5(List<? super B> list) {
   }
}

class Counter<T> {
   T t;

   public int count(T[] ta, T t) {
      this.t = t;
      int count = 0;
      for (T x : ta) {
         count = x == t ? count + 1 : count;
      }
      return count;
   }
}
