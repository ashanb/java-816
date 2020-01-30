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
package lambda.streams.optional;

import java.util.Optional;

/**
 * @author Ashan
 */
public class OptionalTester {
   // How we express “we don’t know” or “not applicable” answer in Java.
   public static Optional<Double> average (int... scores){
      if (scores.length == 0) return Optional.empty();
      int sum = 0;
      for (int score : scores) sum += score;
      return Optional.of((double) sum / scores.length);
   }

   public static void main(String[] args) {
      System.out.println(average(90, 100)); // Optional[95.0]
      System.out.println(average()); // Optional.empty

      final Optional<Double> opt = average(90, 100);
      if (opt.isPresent())
         System.out.println(opt.get()); // 95.0

      final Integer value = null;

      final Optional o1 = (value== null) ? Optional.empty(): Optional.of(value);

      // same as above
      final Optional o2 = Optional.ofNullable(value);

      // ifPresent

      Optional<Double> opt2 = average(90, 100);
      opt2.ifPresent(System.out::println);

      opt2.ifPresent(s -> System.out.println(s));

      System.out.println("------------");

      Optional<Double> opt3 = average();
      System.out.println(opt3.orElse(Double.NaN));
      System.out.println(opt3.orElseGet(() -> Math.random()));
      System.out.println(opt3.orElseThrow(() -> new IllegalStateException()));

      Optional<Double> opt4 = average(90, 100);
      System.out.println(opt4.orElse(Double.NaN));
      System.out.println(opt4.orElseGet(() -> Math.random()));
      System.out.println(opt4.orElseThrow(() -> new IllegalStateException()));
   }
}
