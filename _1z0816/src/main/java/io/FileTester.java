package io;

import java.io.*;

public class FileTester {
   public static void main(String[] args) {
      File file = new File("src\\main\\resources\\io\\zoo.txt"); // relative path
      System.out.println(file.exists());

      if (file.exists()) {
         System.out.println("Absolute Path: " + file.getAbsolutePath());
         System.out.println("Is Directory: " + file.isDirectory());
         System.out.println("Parent Path: " + file.getParent());
         if (file.isFile()) {
            System.out.println("File size: " + file.length());
            System.out.println("File LastModified: " + file.lastModified());
         } else {
            for (File subfile : file.listFiles()) {
               System.out.println("\t" + subfile.getName());
            }
         }
      }

//      File parent = new File("src\\main");
//      File child = new File(parent,"\\resources\\io\\zoo.txt"); // two step file access.
//
//      System.out.println(child.exists());

      // Identify character streams through reader and writer suffix

      System.out.println("--------------------- Low level and High level Streams");

//      try (ObjectInputStream objectStream =
//                   new ObjectInputStream(
//                           new BufferedInputStream(new FileInputStream("src\\main\\resources\\io\\zoo.txt")))) { // not working need to test.
//         System.out.println(objectStream.readObject());
//      } catch (ClassNotFoundException | IOException e) {
//         e.printStackTrace();
//      }

//      new BufferedInputStream(new FileReader("zoo-data.txt")); // DOES NOT COMPILE
//      new BufferedWriter(new FileOutputStream("zoo-data.txt")); // DOES NOT COMPILE
//      new ObjectInputStream(new FileOutputStream("zoo-data.txt")); // DOES NOT COMPILE
//      new BufferedInputStream(new InputStream()); // DOES NOT COMPILE
   }
}
