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


      System.out.println(Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt").subpath(0, 2));

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
      System.out.println(path18.relativize(path19)); // ..\io\zoo.txt  // got it
      System.out.println(path19.relativize(path18)); // ..\..\zoo.properties   // got it

      Path path181 = Paths.get("/src/main/resources/io/a/b/c/my.txt");
      Path path191 = Paths.get("/src/main/resources/io/a/my2.txt");

      System.out.println(path181.relativize(path191)); // ..\..\..\my2.txt // got it
      System.out.println(path191.relativize(path181)); // ..\b\c\my.txt // got it

      Path path182 = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\a\\b\\c\\my.txt"); // no difference with the previous
      Path path192 = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\a\\my2.txt"); // no difference with the previous

      System.out.println(path182.relativize(path192)); //
      System.out.println(path192.relativize(path182)); //

      Path path183 = Paths.get("src/main/resources/io/a/b/c/my.txt");
      Path path193 = Paths.get("src/main/resources/io/a/my2.txt"); // no difference with the previous

      // System.out.println(path191.relativize(path193)); // Exception at runtime (can not mix)

      System.out.println("path183.relativize(path193) :" +path183.relativize(path193)); // ..\..\..\my2.txt // got it correctly

      System.out.println("----------------------------------------------------------------- Path Objects with resolve()");

      final Path path20 = Paths.get("/src/main/resources/io/zoo.txt");
      final Path path21 = Paths.get("src/main/zoo.log"); // meaningless shit :/  \src\main\resources\io\zoo.txt\zoo.log
      System.out.println(path20.resolve(path21));

      ///////////////

      // 181 : "/src/main/resources/io/a/b/c/my.txt" (absoulte)
      // 183 : "src/main/resources/io/a/b/c/my.txt" (relative)

      // 191 : "/src/main/resources/io/a/my2.txt" (absoulte)
      // 193 : "src/main/resources/io/a/my2.txt" (relative)

      // mixing absolute to absolute (191)
      System.out.println(" // mixing absolute to absolute: " + path181.resolve(path191));  // mixing absolute to absolute: \src\main\resources\io\a\my2.txt (191)

      // mixing relative (183) to relative (193)
      System.out.println(" // mixing relative to relative: " + path183.resolve(path193));  // src\main\resources\io\a\b\c\my.txt\src\main\resources\io\a\my2.txt path183 \ path193

      // mixing absolute to relative (193)
      System.out.println("mixing absolute to relative: " + path191.resolve(path193)); // \src\main\resources\io\a\my2.txt\src\main\resources\io\a\my2.txt (191) \ path193

      // mixing relative (193) to absolute (191)
      System.out.println(" // mixing relative to absolute: " + path193.resolve(path191));  // mixing relative to absolute: \src\main\resources\io\a\my2.txt (191)


      System.out.println("----------------------------------------------------------------- normalize()");

      Path path22 = Paths.get("/src/main/resources/io/a/b/c/my.txt");
      Path path23 = Paths.get("/src/main/resources/io/a/my2.txt");
      Path relativePath = path22.relativize(path23); // ..\..\..\my2.txt
      System.out.println(path23.resolve(relativePath)); // \src\main\resources\io\a\my2.txt\..\..\..\my2.txt

      System.out.println("normalize (\\src\\main\\resources\\io\\a\\my2.txt\\..\\..\\..\\my2.txt) : " + path23.resolve(relativePath).normalize()); // \src\main\resources\my2.txt   (jump with spaces) :)

      System.out.println("----------------------------------------------------------------- toRealPath()"); // meaningless shit :/

      // ------------------Works with symbolic links--------------------------
      try {
         System.out.println("Working Dir:" + System.getProperty("user.dir"));  // D:\JavaSE\SE 2\work\java-816\_1z0816
         System.out.println("Path: " + "D:\\JavaSE\\SE 2\\work\\java-816\\_1z0816\\src\\main\\resources\\io\\a\\my2.txt");
         System.out.println("toRealPath: " + Paths.get( "D:\\JavaSE\\SE 2\\work\\java-816\\_1z0816\\src\\main\\resources\\io\\a\\my2.txt").toRealPath());
      } catch (IOException e) {
         throw e;
      }

   }
}
