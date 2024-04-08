package inheritance.ducks3;

public class Rubber extends Duck {
    public Rubber() {
        super("Rubber");
        flyBehaviour = new FlyNoWay();
    }
}
