package bank;


import com.github.javafaker.Faker;

import java.util.ArrayList;

/*
Create a list of NAMES that can expand or shrink
We don't want an array
 */
public class NamesList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 50; i++) {
            names.add(faker.address().firstName() + " "
                    + faker.address().lastName());
        }


//        for(int i = 0; i < names.size(); i++) {
//            String name = names.get(i);
//            System.out.println(name);
//        }

        for(String name : names) {
            System.out.println(name);
        }
    }
}
