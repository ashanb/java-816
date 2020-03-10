package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationTester {
   public static void main(String[] args) {
      System.out.println(Locale.GERMAN); // de
      System.out.println(Locale.GERMANY); // de_DE

      System.out.println(new Locale("fr")); // fr
      System.out.println(new Locale("hi", "IN")); // hi_IN

      Locale l1 = new Locale.Builder()
              .setLanguage("en")
              .setRegion("US")
              .build();

      System.out.println("Builder: " + l1.toString());

      Locale l2 = new Locale.Builder()
              .setRegion("US")
              .setLanguage("en")
              .build();

      System.out.println("Builder: " + l2.toString());

      Locale l3 = new Locale.Builder() // bad practice,  but legal
              .setRegion("us")
              .setLanguage("EN")
              .build();

      System.out.println("Builder: " + l3.toString());

      System.out.println("Default:" + Locale.getDefault()); // en_US

      Locale locale = new Locale("fr");
      Locale.setDefault(locale); // change the default
      System.out.println("Changed Default:" + Locale.getDefault()); // fr


      Locale myLoc = new Locale("fr", "FR");

      ResourceBundle rb = ResourceBundle.getBundle("appmessages", myLoc);

      rb = ResourceBundle.getBundle("appmessages", new Locale("ch", "CH"));

      rb = ResourceBundle.getBundle("appmessages", Locale.CHINA);

   }
}
