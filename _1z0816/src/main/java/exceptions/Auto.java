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
package exceptions;

/**
 * @author Ashan
 */
public class Auto implements AutoCloseable {
   int num;

   Auto(int num) {
      this.num = num;
   }

   public void close() {
      System.out.println("Close: " + num);
   }

   public static void main(String[] args) {
      try (Auto a1 = new Auto(1); Auto a2 = new Auto(2)) {
         throw new RuntimeException();
      } catch (Exception e) {
         System.out.println("ex");
      } finally {
         System.out.println("finally");
      }
   }
}
