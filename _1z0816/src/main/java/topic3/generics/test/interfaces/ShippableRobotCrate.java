package topic3.generics.test.interfaces;
import topic3.generics.test.classes.Robot;

class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) { }
}