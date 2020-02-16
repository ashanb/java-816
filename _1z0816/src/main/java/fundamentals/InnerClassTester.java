package fundamentals;

class Demo {
   void show() {
      System.out.println("i am in show method of super class");
   }
}

class Outer {
   class Inner {    // Simple nested inner class    // 1. Nested Inner class
      // 8
      // public static int x = 10; // inner classes can not have static declarations
      public void show() {
         System.out.println("In a nested class method");
      }

      // we can’t have static method in a nested inner
//      public static void staticShow() {
//         System.out.println("In a nested class method");
//      }
   }

   static class StaticInner { // only inside a class  // remember   // 3. Static nested classes
      void innerMethod() {
         System.out.println("inside innerMethod");
      }

      static void staticShow() {                           // 4. static method inside a static nested class
         System.out.println("In a static class static method");
      }
   }

   void outerMethod() {
      System.out.println("inside outerMethod");
      // Inner class is local to outerMethod()
      class Inner {                 // 2. Method Local inner classes
         void innerMethod() {
            System.out.println("inside innerMethod");
         }
      }

//      static class StaticInner {
//         void innerMethod() {
//            System.out.println("inside innerMethod"); // does not compile.  // remember
//         }
//      }

      Inner y = new Inner();
      y.innerMethod();
   }
}

public class InnerClassTester {
   //  An anonymous class with Demo as base class
   static Demo d = new Demo() {    // 4. Anonymous inner classes
      void show() {
         super.show();
         System.out.println("i am in Flavor1Demo class"); // remember
      }
   };

   public static void main(String[] args) {
      Outer.Inner in = new Outer().new Inner(); // remember
      in.show(); // print

      Outer x = new Outer();
      x.outerMethod(); // print\

      // https://www.geeksforgeeks.org/inner-class-java/
   }
}


