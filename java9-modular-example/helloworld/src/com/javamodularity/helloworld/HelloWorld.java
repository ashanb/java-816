package com.javamodularity.helloworld;

public class HelloWorld {

   public static void main(String... args) {
      System.out.println("Hello Modular World!");
   }
   // compile modules javac -d output/helloworld helloworld/src/com/javamodularity/helloworld/HelloWorld.java helloworld/src/module-info.java

   // jar -cfe mods/helloworld.jar com.javamodularity.helloworld.HelloWorld -C output/helloworld .
}
