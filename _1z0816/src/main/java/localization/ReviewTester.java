package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReviewTester {
   public static void main(String[] args) {
      System.out.println("--------------------------------5");
      Locale fr = new Locale("fr");
      Locale.setDefault(new Locale("en", "US"));
      ResourceBundle b = ResourceBundle.getBundle("Dolphins", fr);
      System.out.println(b.getString("name"));
      System.out.println(b.getString("age"));   // calling to Dolphins.properties (nothing to do with default)
   }
}
