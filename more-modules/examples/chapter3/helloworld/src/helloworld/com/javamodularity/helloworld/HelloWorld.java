package com.javamodularity.helloworld;

public class HelloWorld {

   // ways of compilation:
   // (giving files) javac -d out/helloworld src/helloworld/com/javamodularity/helloworld/HelloWorld.java src/helloworld/module-info.java
   // (giving module) javac -d out --module-source-path src -m helloworld
   
   public static void main(String... args) {
      System.out.println("Hello Modular World!");
   }
   
}