package fundamentals;

import java.util.ArrayList;

enum Days {
   SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; // outside
}

public class EnumTester {

   enum Days1 {         // inside
      SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
   }

   public static void main(String[] args) {

      final Days day = Days.SUNDAY;
      System.out.println("Days enum is set a value = " + day);
      System.out.println("Days.valueOf(\"SUNDAY\") == day = " + (Days.valueOf("SUNDAY") == day));

      System.out.println("Switch = " + enumInIf(day));
   }

   public static String enumInIf(final Days day) {
      if (day == Days.SUNDAY) {
         return "Its Sunday :-)";
      } else if (day == Days.MONDAY) {
         return "Its Monday :*--(";
      } else if (day == Days.TUESDAY) {
         return "Its Tuesday :*-(";
      } else if (day == Days.WEDNESDAY) {
         return "Its Wednesday :*(";
      } else if (day == Days.THURSDAY) {
         return "Its Thursday :)";
      } else if (day == Days.FRIDAY) {
         return "Its Friday ;-D";
      } else {
         return "Its Saturday :=D";
      }
   }

   public ArrayList<String> enumIteration() {
      Days[] days = Days.values();
      ArrayList<String> stringDay = new ArrayList<String>();
      for (Days day : days) {
         stringDay.add(day.toString());
      }
      return stringDay;
   }
}
