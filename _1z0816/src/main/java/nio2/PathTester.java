package nio2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTester {
   public static void main(String[] args) throws URISyntaxException, IOException {

      System.out.println("----------------------------------------------------Direct file access");

      Path path1 = Paths.get("src/main/resources/io/zoo.txt"); // windows relative working
      Path path2 = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt"); // windows personal
      //Path path3 = Paths.get("/home/zoo directory"); // linux or mac

      System.out.println(path1.toRealPath());

      System.out.println("----------------------------------------------------comma(,) separated");

      Path path4 = Paths.get("src", "main", "resources", "io", "zoo.txt"); //  windows relative working
      Path path5 = Paths.get("c:", "Users", "Ashan", "IdeaProjects", "java-816", "_1z0816", "src", "main", "resources", "io", "zoo.txt"); // // windows personal
      //Path path6 = Paths.get("/", "src", "main","resources", "io", "zoo.txt");

      System.out.println(path4.toRealPath());

      // Paths path1 = Paths.get("/alligator/swim.txt"); // DOES NOT COMPILE
      // Path path2 = Path.get("/crocodile/food.csv"); // DOES NOT COMPILE

      System.out.println("-------------------------------------------------------------------URI");

      Path path7 = Paths.get(
              new URI("file://src/main/resources/io/zoo.txt")); // THROWS EXCEPTION // AT RUNTIME
      Path path8 = Paths.get(
              new URI("file:///C:/Users/Ashan/IdeaProjects/java-816/_1z0816/src/main/resources/io/zoo.txt"));
      // Path path9 = Paths.get(new URI("file:///src/main/resources/io/zoo.txt"));

      System.out.println("----------------------------------------------------Internet ~ not working");

      // Path path10 = Paths.get(new URI("http://www.wiley.com")); not sure: java.nio.file.FileSystemNotFoundException: Provider "http" not installed
//      Path path11 = Paths.get(
//              new URI("ftp://username:password@ftp.the-ftp-server.com"));   not sure "main" java.nio.file.FileSystemNotFoundException: Provider "ftp" not installed


      System.out.println("----------------------------------------Accessing the Underlying FileSystem Object");

      Path path12 = FileSystems.getDefault().getPath("/src/main/resources/io/zoo.txt");
      Path path13 = FileSystems.getDefault().getPath("c:", "Users", "Ashan", "IdeaProjects", "java-816", "_1z0816", "src", "main", "resources", "io", "zoo.txt");
      // Path path14 = FileSystems.getDefault().getPath("/home/zoodirector");

      System.out.println("-----------------------------------------------------------------Backward Compatibility");

      File file = new File("src/main/resources/io/zoo.txt");
      Path path = file.toPath();

      path = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt"); // conversion work only full path?
      file = path.toFile();

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
      } else {
         System.out.println("File does not exists");
      }

      System.out.println("----------------------------------------------------------------- Names");

      Path path14 = Paths.get("/src/main/resources/io/zoo.txt");
      System.out.println("The Path Name is: " + path14);
      for (int i = 0; i < path14.getNameCount(); i++) {
         System.out.println(" Element " + i + " is: " + path14.getName(i));
      }


      System.out.println("----------------------------------------------------------------- Absolute or Relative");

      Path path15 = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt");
      System.out.println("Path1 is Absolute? "+path15.isAbsolute());
      System.out.println("Absolute Path1: "+path15.toAbsolutePath());

      Path path16 = Paths.get("/src/main/resources/io/zoo.txt");
      System.out.println("Path2 is Absolute? "+path16.isAbsolute());
      System.out.println("Absolute Path2 "+path16.toAbsolutePath());


      System.out.println(Paths.get("/src/main/resources/io/zoo.txt").isAbsolute()); // true for linux or mac
      System.out.println(Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt").isAbsolute()); // true for windows


      System.out.println("----------------------------------------------------------------- Creating a New Path with subpath()");

      Path path17 = Paths.get("/src/main/resources/io/zoo.txt");
      System.out.println("Path is: "+ path17);
      System.out.println("Subpath from 0 to 3 is: "+path17.subpath(0,3)); // src\main\resources
      System.out.println("Subpath from 1 to 3 is: "+path17.subpath(1,3)); // main\resources
      System.out.println("Subpath from 1 to 2 is: "+path17.subpath(1,2)); // main
      System.out.println("Subpath from 0 to 5 is: "+path17.subpath(0,5)); // src\main\resources\io\zoo.txt
      // System.out.println("Subpath from 0 to 6 is: "+path17.subpath(0,6)); // java.lang.IllegalArgumentException

      // Quick basics from OCA
      System.out.println("0123456789".substring(0,5)); // "01234" 5 not get printed
      System.out.println("0123456789".substring(9)); // 9 get printed
      System.out.println("0123456789".substring(9,9)); // nothing
      System.out.println("0123456789".substring(9,10)); // 9
      //System.out.println("0123456789".substring(9,11)); // java.lang.StringIndexOutOfBoundsException: begin 9, end 11, length 10

      System.out.println("----------------------------------------------------------------- Relativize");

      Path path18 = Paths.get("/src/main/resources/zoo.properties");
      Path path19 = Paths.get("/src/main/resources/io/zoo.txt");
      System.out.println(path18.relativize(path19)); // ..\io\zoo.txt
      System.out.println(path19.relativize(path18)); // ..\..\zoo.properties   // not 100% sure, to come from file to parent ../ should be there (../ -> io -> ../ -> resources)

      System.out.println("----------------------------------------------------------------- Path Objects with resolve()");

      final Path path20 = Paths.get("/src/main/resources/io/zoo.txt");
      final Path path21 = Paths.get("zoo.log"); // meaningless shit :/  \src\main\resources\io\zoo.txt\zoo.log
      System.out.println(path20.resolve(path21));

      System.out.println("----------------------------------------------------------------- normalize()");

      Path path22 = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt");
      Path path23 = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\zoo.properties");
      Path relativePath = path22.relativize(path23);
      System.out.println(path23.resolve(relativePath)); // meaningless shit :/

      System.out.println("----------------------------------------------------------------- toRealPath()"); // meaningless shit :/

      try {
         System.out.println(Paths.get("/src/main/resources/io/zoo.txt").toRealPath());
         System.out.println(Paths.get(".././resources/zoo.properties").toRealPath());
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }

   }
}
