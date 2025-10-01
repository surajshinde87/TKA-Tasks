package main;

import java.util.Scanner;

import com.controllers.AccountController;
import com.controllers.TransactionsController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountController accountController = new AccountController();
        TransactionsController transactionController = new TransactionsController();

        while (true) {
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Account Operations");
            System.out.println("2. Transaction Operations");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    accountController.accountMenu();
                    break;
                case 2:
                    transactionController.transactionMenu();
                    break;
                case 3:
                    System.out.println("Exiting Banking App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
