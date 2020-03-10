package demo;

import com.fasterxml.jackson.databind.ObjectMapper;

// Windows
// javac -cp lib/jackson-annotations-2.8.8.jar;lib/jackson-core-2.8.8.jar  --module-path mods -d out --module-source-path src -m books

// java -cp lib/jackson-annotations-2.8.8.jar;lib/jackson-core-2.8.8.jar  --module-path mods;out -m books/demo.Main

// jdeps
// jdeps -cp jackson-annotations-2.8.8.jar;jackson-core-2.8.8.jar mods/jackson-databind-2.8.8.jar
public class Main {

  public static void main(String... args) throws Exception {
    Book modularityBook =
      new Book("Java 9 Modularity", "Modularize all the things!");

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(modularityBook);
    System.out.println(json);

  }
}
