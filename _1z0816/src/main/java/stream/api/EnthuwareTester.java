package stream.api;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnthuwareTester {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("greg", "dave", "don", "ed", "fred");
      Map<Integer, Long> data = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
      System.out.println(data.values());


      IntStream is1 = IntStream.range(0, 5); //1
      OptionalDouble x = is1.average(); //2
      System.out.println(x); //3


      List<String> letters = Arrays.asList("j", "a", "v", "a");
//1
//      letters.forEach(letter->letter.toUpperCase());
//      letters.forEach(System.out::print);
//2
//      UnaryOperator<String> uo = str->str.toUpperCase();
//      letters.forEach(uo);   // compilation error.
//      letters.forEach(System.out::print);

//3

      UnaryOperator<String> uo = String::toUpperCase;
      letters.replaceAll(uo);
      letters.forEach(System.out::print);

//4
      letters.forEach(letter -> System.out.print(letter.toUpperCase()));
// 5
      System.out.print(letters.stream().collect(Collectors.joining()).toUpperCase());
// 6
      // System.out.print(letters.stream().collect(Collectors.joining(letter->letter.toUpperCase())););

// T1 Q39
      List<String> vals = Arrays.asList("a", "b");
      String join = vals.parallelStream().reduce("_", (a, b) -> a.concat(b));
      System.out.println(join);
   }
}

class Person {
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   private String name;
   private int age;

   public Person(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public static void main(String[] args) {
      List<Person> friends =
              Arrays.asList(
                      new Person("Bob", 31), new Person("Paul", 32),
                      new Person("John", 33));
      double averageAge =
              friends.stream().filter(f -> f.getAge() > 30).mapToInt(f -> f.getAge()).average().getAsDouble();
      System.out.println(averageAge);
   }
}

// T1 Q 47
class Student {
   private String name;

   public Student(String name, int marks) {
      this.name = name;
      this.marks = marks;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getMarks() {
      return marks;
   }

   public void setMarks(int marks) {
      this.marks = marks;
   }

   private int marks;

   public void addMarks(int m) {
      this.marks += m;
   }

   public void debug() {
      System.out.println(name + ":" + marks);
   }

   public static void main(String[] args) {
      List<Student> slist =
              Arrays.asList(
                      new Student("S1", 40),
                      new Student("S2", 35),
                      new Student("S3", 30));
      Consumer<Student> increaseMarks = s -> s.addMarks(10); // Remember
      slist.forEach(increaseMarks);
      slist.forEach(Student::debug);
   }
}

class Book {
   String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public Book(String name, double price) {
      this.name = name;
      this.price = price;
   }

   double price;
}

class Test {
   public static void main(String[] args) {
      List<String> values = Arrays.asList("Alpha A", "Alpha B", "Alpha C"); //INSERT CODE HERE System.out.println(flag);

      System.out.println(values.stream().allMatch(str -> str.equals("Alpha")));
      System.out.println(values.stream().findFirst().get().equals("Alpha"));
      System.out.println(values.stream().findAny().get().equals("Alpha"));
      System.out.println(values.stream().anyMatch(str -> str.equals("Alpha")));

      System.out.println("----------------CRAZY------------------------");
      final int[] counter = {0};
      List<String> values2 = Arrays.asList("Java EE", "C#", "Python");
      boolean flag = values2.stream().allMatch(str -> {
         System.out.println("Testing: " + str);
         counter[0]++;
         return str.equals("Java");
      });
      System.out.println(flag);
      System.out.println(counter[0]);

      System.out.println("--------------------------------------");

      List<List<Book>> books =
              Arrays.asList(
                      Arrays.asList(
                              new Book("Windmills of the Gods", 7.0),
                              new Book("Tell me your dreams", 9.0)),
                      Arrays.asList(
                              new Book("There is a hippy on the highway", 5.0),
                              new Book("Easy come easy go", 5.0)));

      double d = books.stream().flatMap(bs -> bs.stream()).mapToDouble(book -> book.getPrice()).sum();

      System.out.println(d);

      System.out.println("------------------------------");

      List<Integer> ls = Arrays.asList(10, 47, 33, 23);

      ls.stream().max(Comparator.comparing(a -> a)).get();

      ls.stream().reduce((a, b) -> a > b ? a : b);

      //ls.stream().map(a->a).max();


      System.out.println("-------------------------------------");

      IntStream is1 = IntStream.range(1, 3);
      IntStream is2 = IntStream.rangeClosed(1, 3);
      IntStream is3 = IntStream.concat(is1, is2);
      Object val = is3.boxed().collect(Collectors.groupingBy(k -> k)).get(3);
      System.out.println(val);

      System.out.println("-------------------------------------");

      List<Integer> ls2 = Arrays.asList(1, 2, 3);
      System.out.println(ls2.stream().mapToInt(x->x).sum());
      System.out.println(ls2.stream().reduce(0, (a, b)->a+b));


      System.out.println("--------------------------------------");

      List<String> names = Arrays.asList("charles", "chuk", "cynthia", "cho", "cici");
      long x = names.stream().filter(name->name.length()>4).collect(Collectors.counting()); System.out.println(x);
   }
}

class Student2 {
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getMarks() {
      return marks;
   }

   public void setMarks(int marks) {
      this.marks = marks;
   }

   private String name;
   private int marks;

   public Student2(String name, int marks) {
      this.name = name;
      this.marks = marks;
   }

   public String toString() {
      return name + ":" + marks;
   }     //getters and setters not shown

   public static void main(String[] args) {

      List<Student2> ls =
              Arrays.asList(
                      new Student2("S1", 20),
                      new Student2("S3", 30),
                      new Student2("S3", 20));

      //INSERT CODE HERE System.out.println(grouping);
// others not compiling
//      Map<Integer, List<Student2>> grouping =
//              ls.stream().collect(
//                      Collectors.groupingBy(Student2::getMarks,Collectors.mapping(Student2::getName,
//                              Collectors.toList())) );
      // Map<Integer, List<Student>> grouping = ls.stream().collect( Collectors.groupingBy(Student::getMarks,new ArrayList()) );
      //Map<Integer, List<Student2>> grouping = ls.stream().collect( Collectors.groupingBy(Student2::getMarks,Student2) );

      Map<Integer, List<Student2>> grouping = ls.stream().collect(Collectors.groupingBy(s -> s.getMarks())); // Remember
      System.out.println(grouping);
   }
}

