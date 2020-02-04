package localization;

import java.util.*;

public class Tax_en_US extends ListResourceBundle { // Custom Resource bundle
   protected Object[][] getContents() {
      return new Object[][]{{"tax", "new UsTaxCode()"}};
   }

   public static void main(String[] args) {
      ResourceBundle rb = ResourceBundle.getBundle(
              "localization.Tax", Locale.US);
      System.out.println(rb.getObject("tax"));

//      ResourceBundle.getBundle("name");
//      ResourceBundle.getBundle("name", Locale.US);
   }
}
class UsTaxCode { }

