package io;

import java.io.*;
public class PrintWriterSample {
   public static void main(String[] args) throws IOException {
      File source = new File("src\\main\\resources\\io\\zoo.log");
      try (PrintWriter out = new PrintWriter(
              new BufferedWriter(new FileWriter(source)))) {
         out.print("Today's weather is: ");
         out.println("Sunny");
         out.print("Today's temperature at the zoo is: ");
         out.print(1/3.0);
         out.println('C');
         out.format("It has rained 10.12 inches this year");
         out.println();
         out.printf("It may rain 21.2 more inches this year");
         out.print(true);
      }

      File source2 = new File("src\\main\\resources\\io\\zoo2.log");
      try (PrintStream out = new PrintStream(
              new BufferedOutputStream(new FileOutputStream(source2)))) {
         out.print("Today's weather is: ");
         out.println("Sunny");
         out.print("Today's temperature at the zoo is: ");
         out.print(1/3.0);
         out.println('C');
         out.format("It has rained 10.12 inches this year");
         out.println();
         out.printf("It may rain 21.2 more inches this year");
         out.print(true);
      }
   }

   void print(PrintWriter p) {
      p.print(true);
      p.println(true);
   }
}