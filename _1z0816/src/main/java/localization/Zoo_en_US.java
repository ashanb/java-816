package localization;

import java.util.*;

public class Zoo_en_US extends ListResourceBundle {
   protected Object[][] getContents() {
      return new Object[][]{
              {"hello", "Hallo"},
              {"open", "zxxxxxxxxxxx"}};
   }

   public static void main(String[] args) {
      ResourceBundle rb = ResourceBundle.getBundle("Zoo", Locale.US); // java file gets the priority Zoo_en_US.java (move this file outside the package)
      System.out.println(rb.getObject("hello"));
   }
}
