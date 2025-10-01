package com.controllers;

import com.service.TransactionService;
import java.util.Scanner;

public class TransactionsController {

    private TransactionService transactionService = new TransactionService();
    private Scanner sc = new Scanner(System.in);

    public void transactionMenu() {
        while (true) {
            System.out.println("\n--- Transaction Menu ---");
            System.out.println("1. Add Transaction (Deposit/Withdraw)");
            System.out.println("2. View Transactions by Account");
            System.out.println("3. View All Transactions");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account ID: ");
                    int accId = sc.nextInt();
                    System.out.print("Enter Type (Deposit/Withdraw): ");
                    String type = sc.next();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    transactionService.addTransaction(accId, type, amount);
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int accountId = sc.nextInt();
                    transactionService.listTransactionsByAccount(accountId);
                    break;

                case 3:
                    transactionService.listAllTransactions();
                    break;

                case 4:
                    return; 

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
