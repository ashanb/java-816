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
package concurrency.runnable;

/**
 * @author Ashan
 */
public class PrintData implements Runnable {
   public void run() {
      for (int i = 0; i < 3; i++)
         System.out.println("Printing record: " + i);
   }

   public static void main(String[] args) {
      (new Thread(new PrintData())).start();
   }
}
