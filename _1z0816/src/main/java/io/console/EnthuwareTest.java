package io.console;

import java.io.Console;

public class EnthuwareTest {
}

class ConsoleTest {
   public static void main(String[] args) {
      Console c = System.console(); //1
      char[] line = c.readPassword("Please enter your pwd:"); //2
      System.out.println("Pwd is " + new String(line));
   }
}
