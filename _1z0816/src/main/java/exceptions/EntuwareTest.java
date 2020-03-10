package exceptions;

import java.io.IOException;

class LowBalanceException extends WithdrawalException {
   public LowBalanceException(String msg) {
      super(msg);
   }
}

class WithdrawalException extends RuntimeException {
   public WithdrawalException(String msg) {
      super(msg);
   }
}

class Account {
   double balance;

   public void withdraw(double amount) throws WithdrawalException {
      try {
         throw new RuntimeException("Not Implemented");
      } catch (Exception e) {
         throw new LowBalanceException(e.getMessage());
      }
   }

   public static void main(String[] args) {
      try {
         Account a = new Account();
         a.withdraw(100.0);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}

public class EntuwareTest {
}

class Device {
   String header = null;

   public void open() {
      header = "OPENED";
      System.out.println("Device Opened");
   }

   public String read() throws IOException {
      throw new IOException("Unknown");
   }

   public void writeHeader(String str) throws IOException {
      System.out.println("Writing : " + str);
      header = str;
   }

   public void close() {
      header = null;
      System.out.println("Device closed");
   }

//   public static void testDevice() {
//      try (Device d = new Device()) { // compile error
//         d.open();
//         d.read();
//         d.writeHeader("TEST");
//         d.close();
//      } catch (IOException e) {
//         System.out.println("Got Exception");
//      }
//   }

   public static void main(String[] args) {
      // Device.testDevice();
   }
}

class Device2 implements AutoCloseable {
   boolean open = false;

   public Device2() {
      open = true;
   }

   public String read() throws IOException {
      throw new IOException("Can't read!");
   }

   public boolean isOpened() {
      return open;
   }

   public void close() {
      open = false;
      System.out.println("Device closed");
   }

   public static void main(String[] args) {
      Device2 d1 = new Device2();
      try (d1; Device2 d2 = new Device2(); Device2 d3 = new Device2()) {
         d2.read();
      } catch (Exception e) {
         System.out.println("Got Exception " + e.getMessage());
      }
   }
}
