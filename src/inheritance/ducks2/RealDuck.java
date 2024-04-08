package inheritance.ducks2;

public class RealDuck extends Duck {
    public RealDuck(String type) {
        super(type);
    }

    @Override
    public void fly() {
        System.out.println(type + " is flying");
    }

    @Override
    public void quack() {
        System.out.println(type + " says quack");
    }
}
