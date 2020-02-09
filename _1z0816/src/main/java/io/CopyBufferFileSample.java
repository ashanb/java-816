package io;

import java.io.*;
public class CopyBufferFileSample {
   public static void copy(File source, File destination) throws IOException {// performance improvement for using both the Buffered classes
                                                                              // and byte arrays is an order of magnitude faster in practice
      try (
              InputStream in = new BufferedInputStream(new FileInputStream(source));
              OutputStream out = new BufferedOutputStream(
                      new FileOutputStream(destination))) {
         byte[] buffer = new byte[1024];
         int lengthRead;
         while ((lengthRead = in.read(buffer)) > 0) {
            out.write(buffer,0,lengthRead);
            out.flush();
         }
      }
   }

   public static void main(String[] args) throws IOException {
      File source = new File("src\\main\\resources\\io\\zoo.txt");
      File destination = new File("src\\main\\resources\\io\\zoo3.txt");
      copy(source,destination);
   }
}
