package io.serializable;

import java.io.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnthuwareTester {
   public static void main(String[] args) {
      List<Student> sList = new CopyOnWriteArrayList<Student>();
   }
}

class Student {

}

class Booby {
   int i;

   public Booby() {
      i = 10;
      System.out.print("Booby");
   }
}

class Dooby extends Booby implements Serializable {
   int j;

   public Dooby() {
      j = 20;
      System.out.print("Dooby");
   }
}

class Tooby extends Dooby {
   int k;

   public Tooby() {
      k = 30;
      System.out.print("Tooby");
   }
}

class TestClass {
   public static void main(String[] args) throws Exception {
      Tooby t = new Tooby();
      t.i = 100;
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\JavaSE\\SE 2\\work\\java-816\\_1z0816\\src\\main\\resources\\io\\test.ser"));
      oos.writeObject(t);
      oos.close();
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\JavaSE\\SE 2\\work\\java-816\\_1z0816\\src\\main\\resources\\io\\test.ser"));
      t = (Tooby) ois.readObject();
      ois.close();
      System.out.println(t.i + " " + t.j + " " + t.k);
   }
}


