package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesStreamTester {
   public static void main(String[] args) throws IOException {
      System.out.println("---------------- All files in /src");
      Path path1 = Paths.get("src");
      try {
         Files.walk(path1)
                 .filter(p -> p.toString().endsWith(".java"))
                 .forEach(System.out::println);
      } catch (IOException e) {
         // Handle file I/O exception...
      }

      System.out.println("---------------- Search - HelloJava11.java");

      Path path2 = Paths.get("src");
      long dateFilter = 1420070400000l;
      try {
         Stream<Path> stream = Files.find(path2, 10,
                 (p, a) -> p.toString().endsWith("HelloJava11.java")
                         && a.lastModifiedTime().toMillis() > dateFilter);
         stream.forEach(System.out::println);
      } catch (Exception e) {
         throw e;
      }

      System.out.println("---------------- Search - Listing Directory Contents");
      try {
         Path path = Paths.get("src/main/java");
         Files.list(path)
                 .filter(p -> !Files.isDirectory(p)) // D:\JavaSE\SE 2\work\java-816\_1z0816\src\main\java\HelloJava11.java
                 .map(p -> p.toAbsolutePath())
                 .forEach(System.out::println);
      } catch (IOException e) {
         throw e;
      }

      System.out.println("---------------- Printing File Contents");

      try {
         Path path = Paths.get("src/main/resources/io/zoo.txt");
         Files.lines(path).forEach(System.out::println);
      } catch (IOException e) {
         throw e;
      }

      System.out.println("---------------- readAllLines vs lines");

      Files.readAllLines(Paths.get("src/main/resources/io/zoo.txt")).forEach(System.out::println);
      Files.lines(Paths.get("src/main/resources/io/zoo.txt")).forEach(System.out::println);

      // Files.readAllLines(Paths.get("birds.txt")).filter(s -> s.length()>2).forEach(System.out::println); does not compile. // list<String> filter can not apply
      Files.lines(Paths.get("src/main/resources/io/zoo.log")).filter(s -> s.length()>2).forEach(System.out::println); // Stream<String>

   }
}
