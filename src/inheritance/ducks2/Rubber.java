package inheritance.ducks2;

public class Rubber extends ArtificialDuck {
    public Rubber() {
        super("Rubber");
    }

    @Override
    public void quack() {
        System.out.println(type + " says squeek");
    }
}
