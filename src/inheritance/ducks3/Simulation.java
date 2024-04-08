package inheritance.ducks3;

import java.util.ArrayList;

public class Simulation {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();

        ducks.add(new Mallard());
        ducks.add(new Redhead());
        Redhead r = new Redhead();
        r.setFlyBehaviour(new FlyNoWay());
        ducks.add(r);
        ducks.add(new Mallard());
        ducks.add(new Rubber());
        Rubber rub = new Rubber();
        rub.setFlyBehaviour(new FlyWithMotor());
        ducks.add(rub);
        ducks.add(new Crested());
        ducks.add(new Decoy());

        for(Duck d : ducks) {
            d.fly();
            System.out.println();
        }
    }
}
