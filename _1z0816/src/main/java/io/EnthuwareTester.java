package io;

import java.io.*;

public class EnthuwareTester {
   public static void main(String[] args) {

   }
}

class Boo implements Serializable {
   transient int ti = 10; // not serializable
   static int si = 20;
}

class TestClass {
   public static void main(String[] args) throws Exception {
      Boo boo = new Boo();
      boo.si++;
      System.out.println(boo.ti + " " + boo.si);
      FileOutputStream fos = new FileOutputStream("src\\main\\resources\\io\\boo.ser");
      ObjectOutputStream os = new ObjectOutputStream(fos);
      os.writeObject(boo);
      os.close();
      FileInputStream fis = new FileInputStream("src\\main\\resources\\io\\boo.ser");
      ObjectInputStream is = new ObjectInputStream(fis);
      boo = (Boo) is.readObject();
      is.close();
      System.out.println(boo.ti + " " + boo.si);
   }
}
