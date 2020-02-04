package localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleTester {
   public static void main(String[] args) {
      Locale us = new Locale("en", "US");
      Locale france = new Locale("fr", "FR");

      printProperties(us);
      System.out.println();
      printProperties(france);

      System.out.println("\n--------------- Multiple locale test");  // best example

      Locale en_CA = new Locale("en", "CA");
      ResourceBundle rb2 = ResourceBundle.getBundle("Zoo", en_CA);
      System.out.print(rb2.getString("hello"));
      System.out.print(". ");
      System.out.print(rb2.getString("name"));
      System.out.print(" ");
      System.out.print(rb2.getString("open"));
      System.out.print(" ");
      System.out.print(rb2.getString("visitor"));

      System.out.println("\n--------------- bind variables to messages");  // best example

      String format = rb2.getString("helloByName");
      String formatted = MessageFormat.format(format, "Tammy");
      System.out.print(formatted);
   }

   public static void printProperties(Locale locale) {
      System.out.println("---------------ResourceBundle");

      ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
      System.out.println(rb.getString("hello"));
      System.out.println(rb.getString("open"));


      Set<String> keys = rb.keySet();
      keys
      //.map(k -> k + " " + rb.getString(k))
              .forEach(k -> System.out.println(k + " " + rb.getString(k)));

      System.out.println("---------------Property Object");

      Properties props = new Properties();
      rb.keySet().stream()
              .forEach(k -> props.put(k, rb.getString(k)));

      System.out.println(props.get("notReallyAProperty")); // get does not have default value.
      System.out.println(props.getProperty("notReallyAProperty"));
      System.out.println(props.getProperty("notReallyAProperty", "123"));

   }
}
