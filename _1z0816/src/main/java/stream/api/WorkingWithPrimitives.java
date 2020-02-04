package stream.api;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class WorkingWithPrimitives {
   public static void main(String[] args) {
      Stream<Integer> stream = Stream.of(1, 2, 3);
      System.out.println(stream.reduce(0, (s, n) -> s + n));

      // same as above.
      stream = Stream.of(1, 2, 3);
      System.out.println(stream.mapToInt(x -> x).sum());

      IntStream intStream = IntStream.of(1, 2, 3);
      OptionalDouble avg = intStream.average();
      System.out.println(avg.getAsDouble());

      // Creating Primitive Streams

      System.out.println("----------------DoubleStream");

      DoubleStream oneValue = DoubleStream.of(3.14);
      DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
      oneValue.forEach(System.out::println);
      System.out.println();
      varargs.forEach(System.out::println);

      DoubleStream random = DoubleStream.generate(Math::random);
      DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
      random.limit(3).forEach(System.out::println);
      System.out.println();
      fractions.limit(3).forEach(System.out::println);

      System.out.println("----------------IntStream");

      IntStream count = IntStream.iterate(1, n -> n+1).limit(5);
      count.forEach(System.out::println);

      IntStream range = IntStream.range(1, 6);
      range.forEach(System.out::println);

      IntStream rangeClosed = IntStream.rangeClosed(1, 5);
      rangeClosed.forEach(System.out::println);

      Stream<String> objStream = Stream.of("penguin", "fish");
      IntStream intStream2 = objStream.mapToInt(s -> s.length());

      System.out.println("Using Optional with Primitive Streams");

      IntStream stream3 = IntStream.rangeClosed(1,10);
      OptionalDouble optional = stream3.average();

      optional.ifPresent(System.out::println);
      System.out.println(optional.getAsDouble());
      System.out.println(optional.orElseGet(() -> Double.NaN));

      System.out.println("----------------LongStream & DoubleStream");

      LongStream longs = LongStream.of(5, 10);
      long sum = longs.sum();
      System.out.println(sum); // 15

      DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
      OptionalDouble min = doubles.min(); // runs infinitely

      System.out.println("----------------Summarizing Statistics");


   }

   private static int max(IntStream ints) {
      OptionalInt optional = ints.max();
      return optional.orElseThrow(RuntimeException::new);
   }

   private static int range(IntStream ints) {
      IntSummaryStatistics stats = ints.summaryStatistics();
      if (stats.getCount() == 0) throw new RuntimeException();
      return stats.getMax() - stats.getMin();
   }
}
