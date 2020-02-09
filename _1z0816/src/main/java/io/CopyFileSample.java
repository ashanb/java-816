package io;

import java.io.*;
public class CopyFileSample {
   public static void copy(File source, File destination) throws IOException {  // performance improvement for using both the Buffered classes
                                                                              // and byte arrays is an order of magnitude faster in practice
      try (InputStream in = new FileInputStream(source);
           OutputStream out = new FileOutputStream(destination)) {
         int b;
         while((b = in.read()) != -1) {
            out.write(b);
         }
      }
   }
   public static void main(String[] args) throws IOException {
      File source = new File("src\\main\\resources\\io\\zoo.txt");
      File destination = new File("src\\main\\resources\\io\\zoo2.txt");
      copy(source,destination);
   }
}