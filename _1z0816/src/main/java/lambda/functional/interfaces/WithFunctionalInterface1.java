package lambda.functional.interfaces;

import java.util.ArrayList;
import java.util.List;

public class WithFunctionalInterface1 {
    public static void main(String[] argv) {
//        Processor stringProcessor = (str) -> str.length();
//        String name = "Java Lambda";
//        int length = stringProcessor.getStringLength(name);
//        System.out.println(length);


        Processor2 stringProcessor2 = (str) -> {
            System.out.println(str);
        };

        stringProcessor2.justPrint("Hello");


        StringBuilder x = new StringBuilder("Ela kollek");

        List<String> abc = new ArrayList<>();
        abc.add("Ashan");
        abc.add("Bak");

        //Predicate predicate = o -> {return "Ashan".equals(o);};

        abc.removeIf(o -> {return "Ashan1".equals(o);});  // much easier

        System.out.println(abc.size());
    }

    @FunctionalInterface
    interface Processor {
        int getStringLength(String str);
    }

    @FunctionalInterface
    interface Processor2 {
        void justPrint(String str);
    }
}
