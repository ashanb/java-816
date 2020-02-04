package annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;

class base {
   int overriddenMethod() { return 0;}
}

public class AnnotationsTester extends base {
    String str = "";

   public static void main(String[] args) {
      System.out.println("Annotations That Apply to Other Annotations");
   }

//   public static void method(@NotNull String st) { does not support in java 11?
//
//   }

   // Javadoc comment follows
   /**
    * @deprecated
    * explanation of why it was deprecated
    */
   @Deprecated
   static void deprecatedMethod() { }

   static void staticMethod() { }

   // mark method as a superclass method
   // that has been overridden
   @Override
   int overriddenMethod() { return 1;}

   // use a deprecated method and tell
   // compiler not to generate a warning
   @SuppressWarnings("deprecation")
   void useDeprecatedMethod() {
      // deprecation warning
      // - suppressed
      AnnotationsTester annotationsTester = new AnnotationsTester();
      staticMethod();
   }

//   @Schedule(dayOfMonth="last")         // this does not compile
//   @Schedule(dayOfWeek="Fri", hour="23")
//   public void doPeriodicCleanup() { }
//

}

//   @Alert(role="Manager")     // this does not compile
//   @Alert(role="Administrator")
//   class UnauthorizedAccessException extends SecurityException {}

class Schedules implements Schedule {    //  Declare a Repeatable Annotation Type

   @Override
   public String dayOfMonth() {
      return null;
   }

   @Override
   public String dayOfWeek() {
      return null;
   }

   @Override
   public int hour() {
      return 0;
   }

   @Override
   public Class<? extends Annotation> annotationType() {
      return null;
   }
}

// @Repeatable(Schedules.class) // error need to check
@interface Schedule {
   String dayOfMonth() default "first";
   String dayOfWeek() default "Mon";
   int hour() default 12;
}
