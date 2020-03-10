package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ReviewTester {
   public static void main(String[] args) throws IOException {
      System.out.println("------------------------------1");
//      Path path = Path.get("/user/.././root","../kodiacbear.txt"); // code does not compiles
//      path.normalize().relativize("/lion");
//      System.out.println(path);

      System.out.println("------------------------------2");
      Path path = Paths.get("C:\\Users\\Ashan\\IdeaProjects\\java-816\\_1z0816\\src\\main\\resources\\io\\zoo.txt");
      if (Files.isDirectory(path))
         System.out.println(Files.deleteIfExists(path) ? "Success" : "Try Again");

      System.out.println("------------------------------3");
//      Path path2 = Paths.get("sloth.schedule");
//      BasicFileAttributes attributes = Files.readAttributes(path2, BasicFileAttributes.class);
//      if (attributes.size() > 0 && attributes.creationTime().toMillis() > 0) {
//         attributes.setTimes(null, null, null);  // does not compile
//      }

      System.out.println("------------------------------4");

      Path path3 = Paths.get("src/main/resources/io/zoo.txt");
      System.out.println(path3.subpath(1,2));

      System.out.println("------------------------------5");

      Path path4 = Paths.get("/src/main/resources/io/");
      if(Files.isDirectory(path4) && Files.isSymbolicLink(path4))
         Files.createDirectory(path4.resolve("joey"));
   }
}
