package inheritance.ducks3;

public class Decoy extends Duck {
    public Decoy() {
        super("Decoy");
        flyBehaviour = new FlyNoWay();
    }
}
