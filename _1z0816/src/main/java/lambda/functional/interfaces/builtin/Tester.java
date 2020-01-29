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
package lambda.functional.interfaces.builtin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author Ashan
 */
public class Tester {
   public static void main(String[] args) {
      // Supplier LocalDate Factory
      final Supplier<LocalDate> s1 = LocalDate::now;
      final Supplier<LocalDate> s2 = () -> LocalDate.now();

      final LocalDate d1 = s1.get();
      final LocalDate d2 = s2.get();

      System.out.println(d1);
      System.out.println(d2);

      // ----------------- String Builder
      final Supplier<StringBuilder> sb1 = StringBuilder::new;
      final Supplier<StringBuilder> sb2 = () -> new StringBuilder();

      System.out.println(sb1.get());
      System.out.println(sb2.get());

      // ----------------- Array List
      Supplier<ArrayList<String>> s3 = ArrayList::new;
      ArrayList<String> a3 = s3.get();

      a3.add("Ashan");

      System.out.println(a3);

      ArrayList<String> a4 = s3.get();

      a4.add("Bakmeedeniya");

      System.out.println(a4);

      // Consumer and bi-consumer

      final Consumer<String> c1 = System.out::println;
      final Consumer<String> c2 = x -> System.out.println(x);
      c1.accept("Annie");
      c2.accept("Annie");

      final Map<String, Integer> map = new HashMap<>();
      final BiConsumer<String, Integer> b1 = map::put;
      final BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
      b1.accept("chicken", 7);
      b2.accept("chick", 1);
      System.out.println(map);

      // Predicates and bi-predicates

      final BiPredicate<String, String> b12 = String::startsWith;
      final BiPredicate<String, String> b22 = (string, prefix) -> string.startsWith(prefix);
      System.out.println(b12.test("chicken", "chick"));
      System.out.println(b22.test("chicken", "chick"));

      final Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
      final Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

      Predicate<String> egg = s -> s.contains("egg");
      Predicate<String> brown = s -> s.contains("brown");

      Predicate<String> brownEggs1 = egg.and(brown);
      Predicate<String> otherEggs1 = egg.and(brown.negate());

      if (brownEggs1.test("AAeggbrown")) {
         System.out.println("Brown Egg.");
      }

      if (otherEggs1.test("AAegg")) {
         System.out.println("Not Brown Egg.");
      }

      // function and bi-function

      Function<String, Integer> f1 = String::length;
      Function<String, Integer> f2 = x -> x.length();

      System.out.println(f1.apply("cluck")); // 5
      System.out.println(f2.apply("cluck")); // 5


      BiFunction<String, String, String> bb1 = String::concat;
      BiFunction<String, String, String> bb2 = (string, toAdd) -> string.concat(toAdd);

      System.out.println(bb1.apply("baby ", "chick")); // baby chick
      System.out.println(bb2.apply("baby ", "chick")); // baby chick


      // unary Operator and binary operator

      UnaryOperator<String> u1 = String::toUpperCase;
      UnaryOperator<String> u2 = x -> x.toUpperCase();


      System.out.println(u1.apply("chirp"));
      System.out.println(u2.apply("chirp"));

      BinaryOperator<String> bO1 = String::concat;
      BinaryOperator<String> bO2 = (string, toAdd) -> string.concat(toAdd);

      System.out.println(bO1.apply("baby ", "chick")); // baby chick
      System.out.println(bO2.apply("baby ", "chick")); // baby chick
   }
}