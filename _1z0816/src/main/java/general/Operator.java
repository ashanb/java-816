/*
 *                 IFS Research & Development
 *
 *  This program is protected by copyright law and by international
 *  conventions. All licensing, renting, lending or copying (including
 *  for private use), and all other use of the program, which is not
 *  expressively permitted by IFS Research & Development (IFS), is a
 *  violation of the rights of IFS. Such violations will be reported to the
 *  appropriate authorities.
 *
 *  VIOLATIONS OF ANY COPYRIGHT IS PUNISHABLE BY LAW AND CAN LEAD
 *  TO UP TO TWO YEARS OF IMPRISONMENT AND LIABILITY TO PAY DAMAGES.
 */
package general;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 * @author IFS RnD
 */
public abstract class Operator {
   //protected void turnOff();
   public static void main(String[] args) {
      List<String> stringList = new ArrayList<>();

      Stream.of(stringList, stringList);

      Stream<List<String>> iStr = Stream.of(Arrays.asList("1", "John"), Arrays.asList("2", null));

      // String can not convert to int
      //Stream<String> nInt = iStr.flatMapToInt(x -> x.stream());


   }
}

class Test<T> {
   private T t;

   public T get() {
      return t;
   }

   public void set(T t) {
      this.t = t;
   }

   public static void main(String[] args) {
      Test type2 = new Test();
      type2.set(100);
      System.out.println(type2.get());

   }
}

class Product {
   int id;
   int price;

   public Product(int id, int price) {
      this.id = id;
      this.price = price;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "Product{" +
              "id=" + id +
              ", price=" + price +
              '}';
   }

   public static void main(String[] args) {
      //very good one.
      /*List<Product> products = new ArrayList<>(4);

      products.addAll(Arrays.asList(new Product(1, 10), new Product(2, 20), new Product(3, 30)));

      Product product = products.stream().reduce(new Product(4, 0), (p1, p2) -> {
         p1.price+=p2.price;
         return new Product(p1.id, p1.price);
      });

      products.add(product);

      products.stream().parallel().reduce((p1,p2) -> p1.price >p2.price ?p1:p2).ifPresent(System.out::println);*/

      List<String> str = Arrays.asList("my", "pen", "is", "your", "pen");

      Predicate<String> predicate = s -> {
         int i =0;
         boolean result = s.contains("pen");
         System.out.print(i++ + ":");
         return result;
      };

      str.stream().filter(predicate).forEach(System.out::print);

      // 0:0:pen0:0:0:pen  // filter evaluates at last :)


      // Dumps
      String str2  = "Java is Programming Langugae";

      ToIntFunction<String> toIntFunction = str2::indexOf;

      int x = toIntFunction.applyAsInt("Java");

      System.out.println("\nIndex of Java:" + x);


      //

      List<String> colors = Arrays.asList("red", "green", "yellow");
      Predicate<String> test = n -> {
              System.out.println("Searching…");
      return n.contains("red");
};
      colors.stream()
              .filter(c -> c.length() > 3)
              .allMatch(test);
   }
}

class Canvas implements Drawable{

   @Override
   public void draw() {

   }
}

abstract class Board extends Canvas {

}

class Paper extends Canvas {
   protected void draw(int i) {}
}
class Frame extends Canvas implements Drawable {

   @Override
   public void draw() {

   }
}

interface Drawable {
   public abstract void draw ();
}