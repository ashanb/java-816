package generics.collections.gen.test.complex;

import java.util.List;

class Booby {
}

class Dooby extends Booby {
}

class Tooby extends Dooby {
}

public class EnthuwareTests {
   public static void main(String[] args) {
      List<? super Booby> bV = null;

      List<? extends Tooby> tV = null;

      bV.add(tV.get(0));

      // tV.add( bV.get(0) ); // compilation failure

      // bV = tV; // compilation failure

      // tV = bV; // compilation failure
   }
}