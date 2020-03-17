package generics.collections.gen.test.classes;

public class Crate<T> {
    private T contents;
    public T emptyCrate() {
        return contents;
    }
    public void packCrate(T contents) {
        this.contents = contents;
    }

    public static <T, D> Crate<T> ship(T t, D t2) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }
}

class D {

}