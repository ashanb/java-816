package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EnthuwareTester {
   public static void main(String[] args) throws IOException {
      // working
//      Path p1 = Paths.get("c:\\temp\\test.txt");
//      Path p2 = Paths.get("report.pdf");
//      System.out.println(p1.resolve(p2));

      Path p1 = Paths.get("src/main/resources/io/module-info.java");
      Path p2  = Paths.get("src/main/resources/io2/module-info.java");
      Files.move(p1, p2);
   }
}
