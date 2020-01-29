package generics.collections.gen.test.interfaces;

class ShippableAbstractCrate<U> implements Shippable<U> {

//    static U t; not possible.
    public void ship(U t) { }
}