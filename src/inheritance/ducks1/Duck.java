package inheritance.ducks1;

public class Duck {
    protected String type;

    public Duck(String type) {
        this.type = type;
    }

    public void fly() {
        System.out.println(type + " is flying");
    }

    public void quack() {
        System.out.println(type + " says quack");
    }
}
