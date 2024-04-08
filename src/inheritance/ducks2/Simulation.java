package inheritance.ducks2;

import java.util.ArrayList;

public class Simulation {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();

        ducks.add(new Mallard());
        ducks.add(new Redhead());
        ducks.add(new Redhead());
        ducks.add(new Mallard());
        ducks.add(new Rubber());
        ducks.add(new Crested());
        ducks.add(new Decoy());

        for(Duck d : ducks) {
            d.fly();
            d.quack();
            System.out.println();
        }
    }
}
