package bank;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private ArrayList<Account> accounts;
    private int nextId;

    public Bank() {
        nextId = 1;
        accounts = new ArrayList<>();
    }

    // This does not actually connect to DB
    // It loads FAKE accounts
    public void loadAccountsFromDB() {
        Faker faker = new Faker();
        Random rnd = new Random();

        for(int i = 0; i < 50; i++) {
            String name = faker.address().firstName() + " "
                    + faker.address().lastName();
            Account a = addAccount(name, faker.address().fullAddress(),
                    faker.phoneNumber().cellPhone());
            a.setBalance(rnd.nextInt(100000));
            a.setCreditCard(faker.business().creditCardNumber());
        }
    }

    public Account addAccount(String name, String address, String phone) {
        Account newAccount = new Account(nextId, name, address, phone);
        nextId++;
        accounts.add(newAccount);
        return newAccount;
    }

    public void printAccount(int id) {
        for(Account account : accounts) {
            if(account.getId() == id) {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account not found");
    }
}
