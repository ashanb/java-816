package stream.api;

import java.util.function.BooleanSupplier;

public class FunctionalInterfacesForPrimitives {

   public static void main(String[] args) {

      System.out.println("--------------------------------Functional Interfaces for boolean");

      BooleanSupplier b1 = () -> true;
      BooleanSupplier b2 = () -> Math.random() > .5;
      System.out.println(b1.getAsBoolean());
      System.out.println(b2.getAsBoolean());

      System.out.println("--------------------------------Functional Interfaces for double, int, and long");
      // see notes page 211, 212

   }
}
