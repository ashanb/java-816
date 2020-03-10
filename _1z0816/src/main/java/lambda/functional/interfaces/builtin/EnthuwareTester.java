package lambda.functional.interfaces.builtin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class EnthuwareTester {
   public static void main(String[] args) {

   }
}

class Account {
   private String id;

   public Account(String id) {
      this.id = id;
   }     //accessors not shown
}

class BankAccount extends Account {
   private double balance;

   public BankAccount(String id, double balance) {
      super(id);
      this.balance = balance;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public static void main(String[] args) {
      Map<String, Account> myAccts = new HashMap<>();
      myAccts.put("111", new Account("111"));
      myAccts.put("222", new BankAccount("111", 200.0));
      BiFunction<String, Account, Account> bif =
              (a1, a2) ->
                      a2 instanceof BankAccount ? new BankAccount(a1, 300.0) : new Account(a1); //1
      myAccts.computeIfPresent("222", bif); //2
      BankAccount ba = (BankAccount) myAccts.get("222");
      System.out.println(ba.getBalance());
   }
}

class MyProcessor {
   public void process() {
      System.out.println("Processing ");
   }
}
// T1 Q 44
class TestClass {
   public static void main(String[] args) {
      process(MyProcessor::new); //1 REPLACE THIS LINE OF CODE
   }

   public static void process(Supplier<MyProcessor> s) {
      s.get().process();
   }
}

class Test {
   public static void main(String[] args) {
      List<Integer> ls = Arrays.asList(11, 22, 33);
      //INSERT CODE HERE
      UnaryOperator<Integer> func = x->x+10;
      ls.replaceAll(func);
      System.out.println(ls);

      System.out.println("---------------------------------");
      List<Double> dList = Arrays.asList(10.0, 12.0);
      DoubleFunction df = x->x+10;
      // dList.stream().forEach(df);  compilation error
      dList.stream().forEach(d->System.out.println(d));
   }
}