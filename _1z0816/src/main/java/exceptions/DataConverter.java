package exceptions;

import java.io.Console;

public class DataConverter implements AutoCloseable {
   public void copyFiles () {

   }

   public void close()  {

   }

   public static void main(String[] args) {
//      try(DataConverter dataConverter = new DataConverter()) {
//         dataConverter.copyFiles();
//      }
      Console console = System.console();

      char[] pass = console.readPassword("Enter Password");

      String password = new String(pass);
      System.out.println(password);
   }

}
