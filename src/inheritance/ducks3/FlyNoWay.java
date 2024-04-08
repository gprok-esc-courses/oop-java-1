package inheritance.ducks3;

public class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly(String type) {
        System.out.println(type + " does not fly");
    }
}
