package io;

import java.io.Console;
import java.io.IOException;
import java.io.Writer;

public class ReviewTester {
   public static void main(String[] args) throws IOException {
      String line;
      Console c = System.console();
      Writer w = c.writer();
      if ((line = c.readLine()) != null)
         w.append(line);
      w.flush();
   }
}
