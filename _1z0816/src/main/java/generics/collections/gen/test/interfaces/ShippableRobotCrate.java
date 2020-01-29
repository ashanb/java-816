package generics.collections.gen.test.interfaces;
import generics.collections.gen.test.classes.Robot;

class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) { }
}