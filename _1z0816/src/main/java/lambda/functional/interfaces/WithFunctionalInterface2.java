package lambda.functional.interfaces;

public class WithFunctionalInterface2 extends Class2 {

    public static void main(String[] args) {
        ITest1 iTest = (p, s) -> {
            if (p.returnMyName() == "Ashan" && "Hello".equals(s)) {
                return s;
            }
            return "Fuck You";
        };
        System.out.println(iTest.deleteStrings(new Class2(), new String("Hello")));
    }
}

@FunctionalInterface
interface ITest1 {
    String deleteStrings(Class2 parent1, String a);
}


