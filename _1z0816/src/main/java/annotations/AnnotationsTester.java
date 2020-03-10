package annotations;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

class base {
   int overriddenMethod() {
      return 0;
   }
}

public class AnnotationsTester extends base {
   String str = "";

   public static void main(String[] args) {
      System.out.println("Annotations That Apply to Other Annotations");

      UnauthorizedAccessException.print();
   }

   @SuppressWarnings(value = "all")
   static void doElements(List l) {
      l.add("string");
      System.out.println(l.get(0));
   }

//   public static void method(@NotNull String st) { does not support in java 11?
//
//   }

   // Javadoc comment follows

   /**
    * @deprecated explanation of why it was deprecated
    */
   @Deprecated
   static void deprecatedMethod() {
   }

   static void staticMethod() {
   }

   // mark method as a superclass method
   // that has been overridden
   @Override
   int overriddenMethod() {
      return 1;
   }

   // use a deprecated method and tell
   // compiler not to generate a warning
   @SuppressWarnings("deprecation")
   void useDeprecatedMethod() {
      // deprecation warning
      // - suppressed
      AnnotationsTester annotationsTester = new AnnotationsTester();
      staticMethod();
   }

////////////////////////////////@Repeatable////////////////////////////////////////////////////////////////////

//   @Schedule(dayOfMonth="last")         // this does not compile
//   @Schedule(dayOfWeek="Fri", hour="23")
//   public void doPeriodicCleanup() { }
//

}

//   @Alert(role="Manager")     // this does not compile
//   @Alert(role="Administrator")
//   class UnauthorizedAccessException extends SecurityException {}

//class Schedules implements Schedule {    //  Declare a Repeatable Annotation Type
//
//   @Override
//   public String dayOfMonth() {
//      return null;
//   }
//
//   @Override
//   public String dayOfWeek() {
//      return null;
//   }
//
//   @Override
//   public int hour() {
//      return 0;
//   }
//
//   @Override
//   public Class<? extends Annotation> annotationType() {
//      return null;
//   }
//}
////////////////////////////////
// Test 1
@Alert("")
// @Alerts(@Alert("Manager2")) Runtime Exception
// @Alerts(@Alert("Manager1")) Runtime Exception
//@Alert(role = {"Manager1", "Manager2"}) // multiple annotations possible with only after following two declarations. // if one the no repeatable is needed.
@Alert(value="Administrator", type = "ABC", num = 2) // numbers should not have parenthesis
class UnauthorizedAccessException extends SecurityException {
   public static void print() {
      System.out.println("Gained Access");
   }
}

// Remember:
@Repeatable(Alerts.class)
        // container of Alert!
@interface Alert {
   String[] value();

   String[] type() default "XYZ";

   int num() default 1;
}

@interface Alerts { // repeatable Array!
   Alert[] value();
   //String text() default  "Hello"; // if add, default value should be there
}

//////////////////////////////////////
//Test 2
@Repeatable(Schedules.class)
@interface Schedule {
   String dayOfMonth() default "first";

   String dayOfWeek() default "Mon";

   int hour() default 12;
}

@interface Schedules {
   Schedule[] value();

   int hour() default 12;
}

//////////////////////////////////////
//Test 3
//@Repeatable(Meals.class)
//@interface Meal {
//   int id() default 0;
//}
//
//@interface Meals {
//   Meal[] meals();  // no value()
//}

@interface Meals {
   Meal[] value();

   String course() default "maincourse";
}

@Repeatable(Meals.class)
@interface Meal {
   int id() default 0;

   String name();
}

//@interface Meals {
//   Meal[] value();
//
//   String course();  // no default value
//}
//
//@Repeatable(Meals.class)
//@interface Meal {
//   int id() default 0;
//
//   String value();
//}


/////////////////////////////
//Test 4

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface DebugInfo {
   String value();

   String[] params();

   String date();

   int depth();
}

class XYZ {
   @DebugInfo(value = "applyLogic", date = "2019", depth = 10, params = "index")
   void applyLogic(int index) {
      // abc
   }

//   @DebugInfo(value="applyLogic", date = "01/01/2019") // wrong
//   @DebugInfo(depth = 10, params = {"index"})
//   void applyLogic(int index){ }
}


//////////////////////////////////////////////////General////////////////////////////////////////////////////////////
// Test 5

@interface AuthorInfo {
   String name() default "";
}

@AuthorInfo(name= "bob")
// @AuthorInfo("bob") // wrong
class A{
     @AuthorInfo     // correct
  // @AuthorInfo(name="bob") // correct
  // @AuthorInfo("bob") // wrong
   String x = "";

   @AuthorInfo(name= "bob")  // correct
  // @AuthorInfo("bob") // wrong
   void m1(){ };

   void m1(@AuthorInfo int x){ }
}
// @AuthorInfo("bob") // wrong
interface I{
   String x = "";
}

///////////////////////////
//Test 6

@interface AuthorInfo2 {
   String value() default "";
   //String value2() default "";
}
@AuthorInfo2("bob")   // if an only if name is "value"
//@AuthorInfo2("bob", value2= "")   // does not work
class B {
}


////////////////////////////////////////////////////////////


//1
//@SuppressWarnings("unchecked")
// @SuppressWarnings("all") // all is not a valid argument.
class TestClass2 {
   //2
//   @SuppressWarnings("unchecked")
//   @Deprecated
   public static void main(String[] args) throws Exception {
      List<Integer> al = new ArrayList<Integer>();
      printElements(al);
   }
   //3
   //@SuppressWarnings("unchecked")
   @SafeVarargs  // only this.
   static void printElements(List<Integer>... la) {
      for (List<Integer> l : la) {
         System.out.println(l);
      }
   }
}