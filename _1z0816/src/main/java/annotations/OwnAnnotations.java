package annotations;

// "marker annotations":    if variables are not there
// "single value annotations": if have one variables
// "multi value annotations: : if has multiple values

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
   String os() default "Symbian"; // default values

   int version() default 1;

   String[] stringArr() default {"Whatever"};
}

@SmartPhone(os = "Android", version = 1)
        // you have to specify this  (os = , version = ) if default not specified.
class NokiaASeries {
   String model;
   int size;
   public NokiaASeries(String model, int size) {
      this.model = model;
      this.size = size;
   }
}

@SmartPhone(os = "Android", version = 1)
interface ABC { }

@SmartPhone(os = "Android", version = 1, stringArr = "name")
enum Days {
   MON, TUES
}

public class OwnAnnotations {
   public static void main(String[] args) {
      NokiaASeries nokiaASeries = new NokiaASeries("Fire", 5);

      //need to use "Reflection" to read default values of the class
      Annotation annotation = nokiaASeries.getClass().getAnnotation(SmartPhone.class);
      SmartPhone s = (SmartPhone) annotation;
      System.out.println(s);
   }
}
