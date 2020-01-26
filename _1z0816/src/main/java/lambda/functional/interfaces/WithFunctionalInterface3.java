package lambda.functional.interfaces;

import java.util.function.Predicate;

public class WithFunctionalInterface3 {

    public static void main(String[] args) {
        final Class3 parent3 = new Class3();

        parent3.name = "Ashan";

        final ITest3 iTest3 = (p, s) -> {
            // complex logic goes here.
            return s.test(p.returnMyName()) ? 1 : 0;
        };


        System.out.println(iTest3.getInt(parent3, s -> "Ashan".equals(s)));
        
        if("Ashan".equals(parent3.returnMyName())) {
            System.out.println(1);
        }

    }
}

@FunctionalInterface
interface ITest3 {
    int getInt(Class3 parent3, Predicate<String> a);
    default int abc() {
        return 1;
    }
}