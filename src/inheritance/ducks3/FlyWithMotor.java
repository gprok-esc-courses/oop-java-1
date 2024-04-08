package inheritance.ducks3;

public class FlyWithMotor implements FlyBehaviour {
    @Override
    public void fly(String type) {
        System.out.println(type + " flies with motor");
    }
}
