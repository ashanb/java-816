package security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Person {
   private String name;
   private java.time.LocalDate dob;

   private double d;

   public Person(String name, java.time.LocalDate dob) {
      this.name = name;
      this.dob = dob;
      this.d = 1;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public LocalDate getDob() {
      return dob;
   }

   public void setDob(LocalDate dob) {
      this.dob = dob;
   }
}

public class SecurityTester {
   public static void main(String[] args) {
      getEligiblePersons(new ArrayList<>());
   }

   public static List<Person> getEligiblePersons(List<Person> people) {
      var pl = new ArrayList<Person>();
      for (Person p : people) {
         if (p.getDob().isBefore(null)) {
            pl.add(p);
         }
      }
      return pl;
   }
}
