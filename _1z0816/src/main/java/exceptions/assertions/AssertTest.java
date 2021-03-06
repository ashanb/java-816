/*
 *                 IFS Research & Development
 *
 *  This program is protected by copyright law and by international
 *  conventions. All licensing, renting, lending or copying (including
 *  for private use), and all other use of the program, which is not
 *  expressively permitted by IFS Research & Development (IFS), is a
 *  violation of the rights of IFS. Such violations will be reported to the
 *  appropriate authorities.
 *
 *  VIOLATIONS OF ANY COPYRIGHT IS PUNISHABLE BY LAW AND CAN LEAD
 *  TO UP TO TWO YEARS OF IMPRISONMENT AND LIABILITY TO PAY DAMAGES.
 */
package exceptions.assertions;

/**
 * @author Ashan
 */
public class AssertTest {
   public enum Seasons {
      SPRING, SUMMER, FALL, WINTER
   }

   public static void main(String[] args) {
      int numGuests = -5;
      String s = "5";
      boolean b = true;
      assert numGuests < 0;

      assert s != null;

      // assert c = "5";
      System.out.println(numGuests);

      test(Seasons.WINTER);

      processPhoneNumber(null);

   }

   public static void processPhoneNumber(String number) {
      assert number != null && number.length() == 10 : "Invalid phone number";
   }

   public static void test(Seasons s) {
      switch (s) {
         case SPRING:
         case FALL:
            System.out.println("Shorter hours");
            break;
         case SUMMER:
            System.out.println("Longer hours");
            break;
         default:
            assert false : "Invalid season";
      }
   }
}
