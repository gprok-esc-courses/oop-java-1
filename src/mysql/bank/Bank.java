package mysql.bank;

import java.util.Scanner;

public class Bank {
    private Account account;
    private Scanner scanner;

    public Bank() {
        scanner = new Scanner(System.in);
    }

    public int loginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. EXIT");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public int userMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("0. EXIT");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public void register() {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        account = new Account(username, password);
        account.register();
    }

    public boolean login()  {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        account = new Account(username, password);
        return account.login();
    }
}
