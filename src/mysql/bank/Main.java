package mysql.bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        int choice = 0;
        do {
            choice = bank.loginMenu();
            switch (choice) {
                case 1:
                    if(bank.login()) {
                        int option = 0;
                        do {
                            option = bank.userMenu();
                        } while(option != 0);
                    }
                    break;
                case 2:
                    bank.register();
                    break;
            }
        } while(choice != 0);

    }
}
