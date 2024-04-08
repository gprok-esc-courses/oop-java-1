package inheritance.ducks1;

public class Decoy extends Duck {
    public Decoy() {
        super("Decoy");
    }

    @Override
    public void fly() {
        System.out.println(type + " does not fly");
    }

    @Override
    public void quack() {
        System.out.println(type + " does no sound");
    }
}
