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
public class CheckResults {
   private static int counter = 0;

   public static void main(String[] args) throws InterruptedException {
      new Thread(() -> {
         for (int i = 0; i < 500; i++) CheckResults.counter++;
      }).start();
      while (CheckResults.counter < 100) {
         System.out.println("Not reached yet");
         Thread.sleep(1000); // 1 SECOND // this can be done in a similar way by completable futures
      }
      System.out.println("Reached!");
   }
}
