package fundamentals;

import java.util.ArrayList;
import java.util.List;

enum EnumA {A, AA, AAA};

class EnthuwreTestClass {
   public enum EnumB {B, BB, BBB}

   public static enum EnumC {C, CC, CCC}

   public EnthuwreTestClass() {
      // enum EnumD {D, DD, DDD} // compile fail
   }

   public void methodX() {
      // public enum EnumE {E, EE, EEE} // compile fail
   }

   public static void main(String[] args) {
      // enum EnumF {F, FF, FFF} // compile fail
   }
}

class TopClass {
   public Inner inner1 = new Inner() {
      public void doA() {
         System.out.println("doing A");
      }
   };

   public void doA() {
      // inner1.doA(); // does not compile.
      inner1.doB();
   }
}

class Inner {
   int value;

   public void doB() {
   }
}

// T 1 Q 41
interface Account {
   public default String getId() {
      return "0000";
   }
}

interface PremiumAccount extends Account {
   public String getId();
}

class BankAccount implements PremiumAccount {
   public static void main(String[] args) {
      Account acct = new BankAccount();
      System.out.println(acct.getId());
   }

   @Override
   public String getId() {
      return null;
   }
}

class A {
}

class TestClass2 {

   public class A {
      public void m() {
      }
   }

   class B extends A {
      B() {
         m();
      }
   }

   public static void main(String args[]) {
      new TestClass2().new A() {
         public void m() {
         }
      }; //1
      var tc = new TestClass();
      //insert call to A's m() here

      // tc.new A().m(); compile error

      // new TestClass().new A().m()
   }
}

class Outer2 {
   private double d = 10.0;     //put inner class here.

   class Inner {
      public void m1() {
         d = 20.0;
      }
   }
}

interface Boiler {
   public void boil();

   private static void log(String msg) { //1
      System.out.println(msg);
   }

   public static void shutdown() {
      log("shutting down");
   }
}

interface Vaporizer extends Boiler {
   public default void vaporize() {
      boil();
      System.out.println("Vaporized!");
   }
}

class Reactor implements Vaporizer {
   public void boil() {
      System.out.println("Boiling...");
   }

   public static void main(String[] args) {
      Vaporizer v = new Reactor(); //2
      v.vaporize(); //3
      // v.shutdown(); //4 compilation error
      Boiler.shutdown(); // static methods
   }
}

interface Birdie {
   void fly();
}

class Dino implements Birdie {
   public void fly() {
      System.out.println("Dino flies");
   }

   public void eat() {
      System.out.println("Dino eats");
   }
}

class Bino extends Dino {
   public void fly() {
      System.out.println("Bino flies");
   }

   public void eat() {
      System.out.println("Bino eats");
   }
}

class TestClass3 {
   public static void main(String[] args) {
      List<Birdie> m = new ArrayList<>();
      m.add(new Dino());
      m.add(new Bino());
      for (Birdie b : m) {
         b.fly();
         // b.eat(); // does not compile
      }
   }
}