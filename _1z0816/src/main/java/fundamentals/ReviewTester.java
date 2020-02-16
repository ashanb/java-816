package fundamentals;

class Employee {
   public int employeeId;
   public String firstName, lastName;
   public int yearStarted;

   @Override
   public int hashCode() {
      return employeeId;
   }

   public boolean equals(Employee e) {
      return this.employeeId == e.employeeId;
   }

   public static void main(String[] args) {
//      Employee one = new Employee();
//      one.employeeId = 101;
//      Employee two = new Employee();
//      two.employeeId = 101;
//      if (one.equals(two)) System.out.println("Success");
//      else System.out.println("Failure");

      System.out.println("----------6------------------");

      System.out.println(FlavorsEnum.Flavors.CHOCOLATE.ordinal());

      System.out.println("--------7--------------------");

      IceCream.Flavors f = IceCream.Flavors.STRAWBERRY;
//      switch (f) {
//         case 0:
//            System.out.println("vanilla");
//         case 1:
//            System.out.println("chocolate");
//         case 2:
//            System.out.println("strawberry");
//            break;
//         default:
//            System.out.println("missing flavor");
//      }


   }
}

class Book {
   private int ISBN;
   private String title, author;
   private int pageCount;

   public int hashCode() {
      return ISBN;
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof Book)) {
         return false;
      }

      Book other = (Book) obj;
      return this.ISBN == other.ISBN;
   }
// imagine getters and setters are here
}

class FlavorsEnum {
   enum Flavors {
      CHOCOLATE, VANILLA, STRAWBERRY
   }
}

class IceCream {
   enum Flavors {
      VANILLA, CHOCOLATE, STRAWBERRY
   }
}

public class ReviewTester {
}
