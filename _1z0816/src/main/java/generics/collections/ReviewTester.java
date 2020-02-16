package generics.collections;

import java.util.*;

public class ReviewTester {
   public static void main(String[] args) {
      System.out.println("--------3----------------");
//      List list = new ArrayList();
//      list.add("one");
//      list.add("two");
//      list.add(7);
//      for (String s: list) { // compile error
//         System.out.print(s);
//      }

      System.out.println("--------4----------------");
      ArrayDeque<String> greetings = new ArrayDeque<String>();
      greetings.push("hello");
      greetings.push("hi");
      greetings.push("ola");

      greetings.pop();
      greetings.peek();
      while (greetings.peek() != null)
       System.out.print(greetings.pop());

      System.out.println("--------5----------------");

      //HashSet<Number> hs = new HashSet<Integer>();
      HashSet<? super ClassCastException> set = new HashSet<Exception>();
      List<String> list = new Vector<String>();
      //List<Object> values = new HashSet<Object>();
      //List<Object> objects = new ArrayList<? extends Object>();
      Map<String, ? extends Number> hm = new HashMap<String, Integer>();


      System.out.println("--------6----------------");

      System.out.print(new Hello<String>("hi"));
      System.out.print(new Hello("there"));

      System.out.println("--------7----------------");

      Set<Number> numbers = new HashSet<>();
      numbers.add(new Integer(86));
      numbers.add(75);
      numbers.add(new Integer(86));
      numbers.add(null);
      numbers.add(309L);
      Iterator iter = numbers.iterator();
      while (iter.hasNext())
      System.out.print(iter.next());
   }
}

class Hello<T> {
   T t;

   public Hello(T t) {
      this.t = t;
   }

   public String toString() {
      return t.toString();
   }
}