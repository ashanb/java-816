package generics.collections.collections.test;

import java.io.RandomAccessFile;
import java.sql.DriverManager;
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class EnthuwareTester {
   public static void main(String[] args) {
      // Queue
      // "offer" adds an element back of the queue.
      // "push" adds an element front of the queue.
      // "peek" Returns next element or returns null if empty queue
      // "pool" Removes and returns next element or returns null if empty queue

      // Deque
      // pollLast
      // peekLast
      // offerFirst : Inserts the specified element at the front of this deque unless it would
      // pop : words, removes and returns the first element of this deque.
      Deque<Integer> d = new ArrayDeque<>();
      d.add(1);  // 1
      d.push(2); // 1 2
      d.pop(); // 1
      d.offerFirst(3); // 1 3
      d.remove();
      System.out.println(d.pollLast());
      System.out.println(d.pollLast());
      System.out.println(d.pollLast());


     // RandomAccessFile
   }
}

class Request {
}

class RequestCollector {
   //1 : Insert declaration here

   Queue<Request> container = new LinkedList<Request>();

   // LinkedList container = new LinkedList(); // does not compile.

   public synchronized void addRequest(Request r) {
      container.add(r);
   }

   public synchronized Request getRequestToProcess() {
      return container.poll();
   }
}


class Book {
   String isbn;

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   String title;

   public Book(String isbn, String title) {
      this.isbn = isbn;
      this.title = title;
   }

   public int compareTo(Book b) {
      return this.isbn.compareTo(b.isbn);
   }     //accessors not shown

   public static void main(String[] args) {
      List<Book> books = Arrays.asList(new Book("a", "b"), new Book("c", "d"));

      //Collections.sort(books, (b1, b2)->b1.getTitle().compareTo(b2.getTitle()));
      //Collections.sort(books, Comparator.comparing(Book::getTitle));
      // Collections.sort(books); //2 compilation failure

//      var data = new ArrayList<>();
//      data.add("A");
//      data.add(100);//1
//      data.add("C");
//      data.set(0, 200);//2    // fail at runtime?
//      data.remove(2); //3
//      data.set(2, 101L);//4
//      System.out.println(data);

      String val1 = "hello";
      StringBuilder val2 = new StringBuilder("world");
      UnaryOperator<String> uo1 = s1 -> s1.concat(val1); //1

      UnaryOperator<String> uo2 = s -> s.toUpperCase(); //2

      System.out.println(uo1.apply(uo2.apply(String.valueOf(val2)))); //3  if wrapped with  String.valueOf()  -> WORLDhello
   }
}

class Calculator {
   public static void main(String[] args) {
      double principle = 100;
      int interestrate = 5;

      double amount = compute(principle, x -> x * interestrate);
   }
   public static double compute(double base, Function<Double, Double> func){
      return func.apply(base); }
}

class Test {

   public static void main(String[] args) {
      String[] names = {"Alex", "Bob", "Charlie" };   //Insert code here   System.out.println(list.get(0));

      List<?> list = new ArrayList<>(Arrays.asList(names));

      List<String> list2 = new ArrayList<>(Arrays.asList(names));
   }
}


