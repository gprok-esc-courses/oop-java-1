package inheritance.ducks3;

public class Crested extends Duck {
    public Crested() {
        super("Crested");
        flyBehaviour = new FlyWithWings();
    }
}
