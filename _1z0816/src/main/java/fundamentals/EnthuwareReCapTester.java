package fundamentals;

public class EnthuwareReCapTester {
   public static void main(String[] args) {

   }
}
// Question 1: Started:
interface Book3 {
   public default String getId() {
      return "ISBN123456";
   }
}

interface Encyclopedia extends Book3 {
//   default String getId() {   // this is also possible
//      return "AIN8888";
//   }


   String getId(); // keep this way.

//   private String getId() {  // attempting to set weaker privileges
//      return "x";
//   }
}
// Question 1: Ended