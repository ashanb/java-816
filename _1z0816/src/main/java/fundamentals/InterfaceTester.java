package fundamentals;


abstract class AbstractClassTester {
   private int privateMtd() {
      return 1;
   }

   private static int privateStaticMtd() {
      return 1;
   }

   final int privateStaticMtd2() { // java 9 (remember this)
      return 1;
   }
}

interface ITester {
   int i = 0; // public static final

   int abstractMtd();  // java 7 all public methods

   default int defaultMtd() { // java 8
      return privateStaticMtd();
   }

   static int staticMtd() { // java 8
      return 0;
   }

   private int privateMtd() { // java 9 (remember this)
      return 1;
   }

   private static int privateStaticMtd() { // java 9 (remember this)
      return 1;
   }

//   final int privateStaticMtd2() { // java 9 (remember this)
//      return 1;
//   }
}

class AbstractClassImplementation extends AbstractClassTester {

}

public class InterfaceTester implements ITester {
   @Override
   public int abstractMtd() {
      return 0;
   }

   public static void main(String[] args) {
      ITester iTester = new InterfaceTester();

      System.out.println("interface override abstract method:" + iTester.abstractMtd()); // call to abstract
      System.out.println("interface default method:" + iTester.defaultMtd()); // call to default
      System.out.println("interface static method:" + ITester.staticMtd()); // call to static

      // no way of calling the private method outside the interface? yes :)  code re-usability inside interfaces
      // Private method can be used only inside interface.
      // check more info at https://www.geeksforgeeks.org/private-methods-java-9-interfaces/

      // Testing with abstract class

      AbstractClassTester abstractClassTester = new AbstractClassImplementation();

      // can not access private methods, this not a new thing for abstract classes :)
   }
}


interface House {
   public default String getAddress() {
      return "101 Main Str";
   }
}

interface Office {
   public default String getAddress() {
      return "101 Smart Str";
   }
}

class HomeOffice implements House, Office {
   @Override
   public String getAddress() {
      return "R No 1, Home";
   }
}

class TestClass {
   public static void main(String[] args) {
      House h = new HomeOffice();
      System.out.println(h.getAddress());
   }
}
