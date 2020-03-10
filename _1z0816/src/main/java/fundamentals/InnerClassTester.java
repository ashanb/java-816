package fundamentals;

class Demo {
   void show() {
      System.out.println("i am in show method of super class");
   }
}


class Outer {
   private final String a = "1";
   private final static String b = "2";
   String c = "3";

   static void staticMethod() {
      class staticInner{
         void method() {
            //System.out.println(a);
            System.out.println(b);
            //System.out.println(c);
         }
      }
   }

   static interface interFace {
     static String a = "b";
   }

   protected abstract class InnerAbstract  { abstract void abc(); }

   public class Inner extends EnumTester {    // Simple nested inner class    // 1. Nested Inner class

      static final String d = "5";   // "Adenava"
      final String a ="s";
      // 8
      // public static int x = 10; // inner classes can not have static declarations
      public void show() {

         System.out.println(a);
         System.out.println(b);
         System.out.println(c);
         System.out.println("In a nested class method");
      }

      // we can’t have static method in a nested inner
//      public static void staticShow() {
//         System.out.println("In a nested class method");
//      }

        // no static members
//      static class StaticInner { // only inside a class  // remember   // 3. Static nested classes
//         static String a = "5";
//         void innerMethod() {
//            System.out.println("inside innerMethod");
//         }
//
//         static void staticShow() {                           // 4. static method inside a static nested class
//            System.out.println("In a static class static method");
//         }
//      }
   }

   static class StaticInner { // only inside a class  // remember   // 3. Static nested classes
      static String a = "5";
      String b = "c";

      void innerMethod() {
         System.out.println("inside innerMethod");
      }

      static void staticShow() {                           // 4. static method inside a static nested class
         System.out.println("In a static class static method");
      }

      class bbc {

      }

   }

   void outerMethod() {
      System.out.println("inside outerMethod");
      // Inner class is local to outerMethod()
      class Inner extends Demo {                 // 2. Method Local inner classes
         final String d ="s";

         void innerMethod() {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
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

   static String a ="5";
   static Demo d = new Demo() {    // 4. Anonymous inner classes
      void show() {
         super.show();
         System.out.println("i am in Flavor1Demo class"); // remember
      }
   };


   interface AnonymousInnerInterface  {
      void run ();
   }

   public static void main(String[] args) {
      a.length();
      Outer.Inner in = new Outer().new Inner(); // remember.
      in.show(); // print

      Outer.StaticInner staticInner = new Outer.StaticInner(); // remember.

      Outer x = new Outer();
      x.outerMethod(); // print\
      // x= null;

      // https://www.geeksforgeeks.org/inner-class-java/

      // anonymous inner class
      AnonymousInnerInterface anonymousInnerInterface = new AnonymousInnerInterface() {
         //static  String a = "5";
         @Override
         public void run() {
         }
      };

      class C{
         public void main() {   // all the methods inside are static.
            System.out.println(x);  // x is automatic variable (effective final variables)
         }
      };

      new C().main(); // remember.

   }
}


