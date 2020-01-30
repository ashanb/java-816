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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

/**
 * @author Ashan
 */
public class ExceptionTester {
   public static void main(String[] args) {
      // “I give up. I don’t know what to do right now. You deal with it.”

/*      try {
         throw new IOException();
      } catch (FileNotFoundException | IOException e) { } // DOES NOT COMPILE
      */

      try (JammedTurkeyCage t = new JammedTurkeyCage()) {
         throw new IllegalStateException("turkeys ran off");
      } catch (IllegalStateException e) {
         System.out.println("caught: " + e.getMessage());
         for (Throwable t : e.getSuppressed())
            System.out.println(t.getMessage());
      }

      // below commented throw Unhandled exception thrown
      // Exception in thread "main" java.lang.RuntimeException: turkeys ran off
      // Suppressed: java.lang.IllegalStateException: Cage door does not close

/*      try (JammedTurkeyCage t = new JammedTurkeyCage()) {
         throw new RuntimeException("turkeys ran off");
      } catch (IllegalStateException e) {
         System.out.println("caught: " + e.getMessage());
      }*/

      System.out.println("------------------- ");
      try (JammedTurkeyCage t1 = new JammedTurkeyCage();
           JammedTurkeyCage t2 = new JammedTurkeyCage()) {
         System.out.println("turkeys entered cages");
      } catch (IllegalStateException e) {
         System.out.println("caught: " + e.getMessage());
         for (Throwable t : e.getSuppressed())
            System.out.println(t.getMessage());
      }

      System.out.println("------------------- ");
      try (JammedTurkeyCage t = new JammedTurkeyCage()) {
         throw new IllegalStateException("turkeys ran off");
      } finally {
         throw new RuntimeException("and we couldn't find them");
      }
   }

   public void multiCatch() throws SQLException, DateTimeParseException, IOException {
      try {
         parseData();
      } catch (SQLException | DateTimeParseException | IOException e) {
         System.err.println(e);
         throw e;
      }
   }

   public void rethrowing() throws SQLException, DateTimeParseException, IOException { // this is much better than multiCatch
      try {
         parseData();
      } catch (Exception e) {
         System.err.println(e);
         throw e;
      }
   }

   public void parseData() throws SQLException, IOException {
      // if a new checked exception ("IOException) added, all the caller methods needs to be changed.
   }

   public void doesNotCompile() { // METHOD DOES NOT COMPILE
//      try {
//         mightThrow();
//      } catch (FileNotFoundException | IllegalStateException e) {
//      } catch (InputMismatchException e |MissingResourceException e){
//      } catch(SQLException | ArrayIndexOutOfBoundsException e){
//      } catch(FileNotFoundException | IllegalArgumentException e){
//      } catch(Exception e){
//      } catch(IOException e){
//      }
   }

   private void mightThrow() throws DateTimeParseException, IOException {
   }
}
