package nio2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.Charset.forName;
import static java.nio.file.Files.*;

public class FilesTester {
   public static void main(String[] args) throws IOException {
//      Path p1 = Paths.get("c:\\temp\\test1.txt");
//
//      Path p2  = Paths.get("c:\\temp\\test2.txt");
//
//
//      //Files.move(p1, p2);
//
//      Files.move(p1, p2, StandardCopyOption.REPLACE_EXISTING);
//
//      Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
//
//      Files.delete(p1);
//
//      // try(move(p1, p2)){ }

      //////////////////////
      System.out.println("Path exists :" + exists(Paths.get("src/main/resources/io/zoo.txt")));



      try {
         System.out.println(isSameFile(Paths.get("src/main/resources/io/zoo.txt"), // true
                 Paths.get("src/main/resources/io/zoo.txt")));
         System.out.println(isSameFile(Paths.get("src/main/resources/io/../Zoo.properties"), // true
                 Paths.get("src/main/resources/Zoo.properties")));
         System.out.println(isSameFile(Paths.get("src/main/resources/io/./zoo.txt"), // true
                 Paths.get("src/main/resources/io/zoo.txt")));
         System.out.println(isSameFile(Paths.get("src/main/resources/io/zoo.txt"), // false
                 Paths.get("src/main/resources/Zoo.properties")));
      } catch (IOException e) {
         System.out.println("IO Exception Occurred");
         throw e;
      }

      System.out.println("----------------------------------------------- Create New Directory/s");
      try {
         createDirectory(Paths.get("src/main/resources/io2"));
         createDirectories(Paths.get("src/main/resources/io/io3"));
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }

      System.out.println("----------------------------------------------- Duplicating file contents with copy.");

      try {
         copy(Paths.get("src/main/resources/io"), Paths.get("src/main/resources/io4"));
         copy(Paths.get("src/main/resources/io/zoo.txt"), Paths.get("src/main/resources/io4/zoo.txt"));
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }

      System.out.println("----------------------------------------------- Copying Files with java.io and NIO.2");

      try (InputStream is = new FileInputStream("src/main/resources/io/zoo.txt");
           OutputStream out = new FileOutputStream("src/main/resources/io/output-zoo.txt")) {
         // Copy stream data to file
         copy(is, Paths.get("src/main/resources/io/output-stream-zoo.txt"));
         // Copy file data to stream
         copy(Paths.get("src/main/resources/io/output-stream-zoo.txt"), out);
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }
      System.out.println("----------------------------------------------- Changing a File Location with move()");

      try {
         move(Paths.get("src/main/resources/io/output-stream-zoo.txt"), Paths.get("src/main/resources/io4/output-stream-zoo.txt"));
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }

      System.out.println("--------------------------- Removing a File with delete() and deleteIfExists()");

//      try {
//         delete(Paths.get("src/main/resources/io/output-zoo.txt"));
//         delete(Paths.get("src/main/resources/io/io3"));
//         delete(Paths.get("src/main/resources/io4/output-stream-zoo.txt"));
//         delete(Paths.get("src/main/resources/io4/zoo.txt"));
//         deleteIfExists(Paths.get("src/main/resources/io2"));
//         delete(Paths.get("src/main/resources/io4"));
//      } catch (IOException e) {
//         throw e;
//      }

      System.out.println("--------------- Reading and Writing File Data with newBufferedReader() and newBufferedWriter()");

      Path path1 = Paths.get("src/main/resources/io/zoo.txt");
      try (BufferedReader reader = newBufferedReader(path1, forName("US-ASCII"))) {
                  // Read from the stream
         String currentLine = null;
         while((currentLine = reader.readLine()) != null)
            System.out.println(currentLine);
      } catch (IOException e) {
               // Handle file I/O exception...
      }

      Path path2 = Paths.get("src/main/resources/io/zoo5.txt");
      List<String> data = new ArrayList();
      try (BufferedWriter writer = newBufferedWriter(path2,
              Charset.forName("UTF-16"))) {
         writer.write("Hello World");
      } catch (IOException e) {
            // Handle file I/O exception...
      }

      System.out.println("--------------- Reading Files with readAllLines()");

      Path path3 = Paths.get("src/main/resources/io/zoo.txt");
      try {
         final List<String> lines = readAllLines(path3);
         for(String line: lines) {
            System.out.println(line);
         }
      } catch (IOException e) {
            throw e;
      }

      // Understanding File Attributes not for EXAM

   }
}
