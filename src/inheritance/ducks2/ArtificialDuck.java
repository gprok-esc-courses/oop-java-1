package inheritance.ducks2;

public class ArtificialDuck extends Duck {
    public ArtificialDuck(String type) {
        super(type);
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
