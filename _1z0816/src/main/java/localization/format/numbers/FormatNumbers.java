package localization.format.numbers;

import java.text.*;
import java.util.*;

public class FormatNumbers {
   public static void main(String[] args) throws ParseException {
      int attendeesPerYear = 3_200_000;
      int attendeesPerMonth = attendeesPerYear / 12;

      NumberFormat us = NumberFormat.getInstance(Locale.US);
      System.out.println(us.format(attendeesPerMonth));
      NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
      System.out.println(g.format(attendeesPerMonth));
      NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
      System.out.println(ca.format(attendeesPerMonth));


      System.out.println("----------------------------Currency Instance");

      double price = 48;
      NumberFormat us2 = NumberFormat.getCurrencyInstance();
      System.out.println(us2.format(price)); // "format" converts to $48

      System.out.println("----------------------------Parse using right local");

      NumberFormat en = NumberFormat.getInstance(Locale.US);
      NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);
      String s = "40.45";
      System.out.println(en.parse(s)); // 40.45
      System.out.println(fr.parse(s)); // 40 <-- you will use the decimals.

      NumberFormat nf = NumberFormat.getInstance();
      String one = "456abc";
      String two = "-2.5165x10";
      String three = "x85.3";
      System.out.println(nf.parse(one)); // 456
      System.out.println(nf.parse(two)); // -2.5165
      // System.out.println(nf.parse(three));// throws ParseException

      System.out.println("----------------------------Parse Currency to number");

      String amt = "$92,807.99asasass";
      NumberFormat cf = NumberFormat.getCurrencyInstance();
      double value = (Double) cf.parse(amt); // "parse" converts to number
      System.out.println(value); // 92807.99

   }
}