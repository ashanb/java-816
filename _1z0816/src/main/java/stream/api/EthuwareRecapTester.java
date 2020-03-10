package stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EthuwareRecapTester {
   public static void main(String[] args) {

      System.out.println("Question 1-----------------");
      Stream<Integer> stream = Stream.iterate(1, n -> n + 1);

      long l1 = stream.limit(10).count(); // limit makes the infinite loop to normal loop.
      System.out.println(l1);

//      long l2 =  stream.limit(10).count(); // fail to open the previously closed stream.
//      System.out.println(l2);

      System.out.println("Question 2-----------------");

      List<Integer> str = Arrays.asList(1,2, 3, 4 );
      Stream<Integer> integerStream = str.stream().filter(
              x->{
                 System.out.print(x+" ");
                 return x>2; });
      System.out.println("count is : " + integerStream.count());
   }
}
