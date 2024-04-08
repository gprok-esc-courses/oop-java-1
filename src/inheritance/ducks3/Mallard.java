package inheritance.ducks3;

public class Mallard extends Duck {
    public Mallard() {
        super("Mallard");
        flyBehaviour = new FlyWithWings();
    }
}
