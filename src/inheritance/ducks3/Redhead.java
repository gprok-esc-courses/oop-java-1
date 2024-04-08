package inheritance.ducks3;

public class Redhead extends Duck {
    public Redhead() {
        super("Redhead");
        flyBehaviour = new FlyWithWings();
    }
}
