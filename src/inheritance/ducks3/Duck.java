package inheritance.ducks3;

public class Duck {
    protected FlyBehaviour flyBehaviour;
    protected String type;

    public Duck(String type) {
        this.type = type;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void fly() {
        flyBehaviour.fly(type);
    }
}
