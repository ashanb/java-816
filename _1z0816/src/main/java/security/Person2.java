package security;

public class Person2 {
   private String name;
   private java.util.Date dob;

   public Person2(String name, java.util.Date dob) {
      this.name = name;
      this.dob = dob;
   }

   public String getName() {
      return name;
   }

   public java.util.Date getDob() {
      return dob;
   }
}
