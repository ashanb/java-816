package fundamentals;

interface Age {
   final int x = 21;

   void getAge(); // if one method is in the interface (functional interface) can write with a method reference
   void anotherMethod();
}

public class AnonymousInnerClassTester {
   public static void main(String[] args) {
      final Age oj1 = new Age() { // anonymous Inner class
         @Override
         public void getAge() {
            System.out.print("Age is "+x);
         }

         @Override
         public void anotherMethod() { }
      };
   }
}

