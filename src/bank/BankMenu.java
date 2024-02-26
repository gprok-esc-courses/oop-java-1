package bank;

import java.util.Scanner;

public class BankMenu {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadAccountsFromDB();
        Scanner input = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("0. EXIT");
            System.out.print("Select: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.print("Account ID: ");
                    int id = input.nextInt();
                    bank.printAccount(id);
            }


        } while(choice != 0);
    }
}
