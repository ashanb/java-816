package nio2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.Charset.forName;

public class FilesTester {
   public static void main(String[] args) throws IOException {
      try {
         System.out.println(Files.isSameFile(Paths.get("src/main/resources/io/zoo.txt"), // true
                 Paths.get("src/main/resources/io/zoo.txt")));
         System.out.println(Files.isSameFile(Paths.get("src/main/resources/io/../Zoo.properties"), // true
                 Paths.get("src/main/resources/Zoo.properties")));
         System.out.println(Files.isSameFile(Paths.get("src/main/resources/io/./zoo.txt"), // true
                 Paths.get("src/main/resources/io/zoo.txt")));
         System.out.println(Files.isSameFile(Paths.get("src/main/resources/io/zoo.txt"), // false
                 Paths.get("src/main/resources/Zoo.properties")));
      } catch (IOException e) {
         System.out.println("IO Exception Occurred");
         throw e;
      }

      System.out.println("----------------------------------------------- Create New Directory/s");
      try {
         Files.createDirectory(Paths.get("src/main/resources/io2"));
         Files.createDirectories(Paths.get("src/main/resources/io/io3"));
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }

      System.out.println("----------------------------------------------- Duplicating file contents with copy.");

      try {
         Files.copy(Paths.get("src/main/resources/io"), Paths.get("src/main/resources/io4"));
         Files.copy(Paths.get("src/main/resources/io/zoo.txt"), Paths.get("src/main/resources/io4/zoo.txt"));
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
         Files.copy(is, Paths.get("src/main/resources/io/output-stream-zoo.txt"));
         // Copy file data to stream
         Files.copy(Paths.get("src/main/resources/io/output-stream-zoo.txt"), out);
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }
      System.out.println("----------------------------------------------- Changing a File Location with move()");

      try {
         Files.move(Paths.get("src/main/resources/io/output-stream-zoo.txt"), Paths.get("src/main/resources/io4/output-stream-zoo.txt"));
      } catch (IOException e) {
         if (e instanceof FileAlreadyExistsException) {
            System.out.println("Files Already Created");
         } else {
            throw e;
         }
      }

      System.out.println("--------------------------- Removing a File with delete() and deleteIfExists()");

      try {
         Files.delete(Paths.get("src/main/resources/io/output-zoo.txt"));
         Files.delete(Paths.get("src/main/resources/io/io3"));
         Files.delete(Paths.get("src/main/resources/io4/output-stream-zoo.txt"));
         Files.delete(Paths.get("src/main/resources/io4/zoo.txt"));
         Files.deleteIfExists(Paths.get("src/main/resources/io2"));
         Files.delete(Paths.get("src/main/resources/io4"));
      } catch (IOException e) {
         throw e;
      }

      System.out.println("--------------- Reading and Writing File Data with newBufferedReader() and newBufferedWriter()");

      Path path1 = Paths.get("src/main/resources/io/zoo.txt");
      try (BufferedReader reader = Files.newBufferedReader(path1, forName("US-ASCII"))) {
                  // Read from the stream
         String currentLine = null;
         while((currentLine = reader.readLine()) != null)
            System.out.println(currentLine);
      } catch (IOException e) {
               // Handle file I/O exception...
      }

      Path path2 = Paths.get("src/main/resources/io/zoo5.txt");
      List<String> data = new ArrayList();
      try (BufferedWriter writer = Files.newBufferedWriter(path2,
              Charset.forName("UTF-16"))) {
         writer.write("Hello World");
      } catch (IOException e) {
            // Handle file I/O exception...
      }

      System.out.println("--------------- Reading Files with readAllLines()");

      Path path3 = Paths.get("src/main/resources/io/zoo.txt");
      try {
         final List<String> lines = Files.readAllLines(path3);
         for(String line: lines) {
            System.out.println(line);
         }
      } catch (IOException e) {
            throw e;
      }

      // Understanding File Attributes not for EXAM

   }
}
