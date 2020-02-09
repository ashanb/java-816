package nio2;

import java.nio.file.*;
public class PathFilePathTest {
   public static void printPathInformation(Path path) {
      System.out.println("Filename is: "+path.getFileName());
      System.out.println("Root is: "+path.getRoot());
      Path currentParent = path;
      while((currentParent = currentParent.getParent()) != null) {
         System.out.println(" Current parent is: "+currentParent);
      }
   }
   public static void main(String[] args) {
      printPathInformation(Paths.get("/src/main/resources/io/zoo.txt"));
      System.out.println();
      printPathInformation(Paths.get("io/zoo.txt"));  // if '/' not there root is null.
   }
}