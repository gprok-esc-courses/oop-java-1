package inheritance.ducks1;

public class Rubber extends Duck {
    public Rubber() {
        super("Rubber");
    }

    @Override
    public void fly() {
        System.out.println(type + " does not fly");
    }

    @Override
    public void quack() {
        System.out.println(type + " says squeek");
    }
}
