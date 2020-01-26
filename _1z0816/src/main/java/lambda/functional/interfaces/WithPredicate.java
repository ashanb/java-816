package lambda.functional.interfaces;

import java.util.function.Predicate;

public class WithPredicate {
    /*w  w  w. ja  va  2  s .  com*/
    public static void main(String[] args) {
//        MyIntegerCalculator myIntegerCalculator = (s1, s2) -> s1 * 2;;
//
//        System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5, 6));


//        MyIntegerCalculator myIntegerCalculator3 = (Integer s1) -> s1 * 4;
//
//        System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5));


        Predicate<String> predicate = s -> {
            String x = s;
            return ("Ashan".equals(x) && "Ashan" == x);
        };

        System.out.println(predicate.test("Ashan"));
    }
}

