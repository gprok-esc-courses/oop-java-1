package inheritance.ducks2;

public abstract class Duck {
    protected String type;

    public Duck(String type) {
        this.type = type;
    }

    public abstract void fly();

    public abstract void quack();
}
