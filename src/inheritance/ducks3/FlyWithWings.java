package inheritance.ducks3;

public class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly(String type) {
        System.out.println(type + " flies with wings");
    }
}
