package com.javamodularity.helloworld;

public class HelloWorld {

   public static void main(String... args) {
      System.out.println("Hello Modular World!");
   }

   // Due to the way I have created this modules
   // Compile is different than others (ex: javac -d out --module-source-path src -m helloworld)

   // compile modules:  javac -d output/helloworld helloworld/src/com/javamodularity/helloworld/HelloWorld.java helloworld/src/module-info.java

   // package: jar -cfe mods/helloworld.jar com.javamodularity.helloworld.HelloWorld -C output/helloworld .

   // run from Class: java --module-path output --module helloworld/com.javamodularity.helloworld.HelloWorld

   // run from Class (short form): java -p output -m helloworld/com.javamodularity.helloworld.HelloWorld

   // run from packaged module jar (short form): java -p mods  -m helloworld

   // run (see the resolution) java --show-module-resolution --limit-modules java.base -p mods -m helloworld

   // to see the dependent modules: jdeps --module-path output --module helloworld

  // path  tree : tree /a /f

   // create a image: jlink --module-path mods --add-modules helloworld --launcher hello=helloworld --output helloworld-image

}
