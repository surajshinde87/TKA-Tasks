package com.controllers;

import com.service.AccountService;
import java.util.Scanner;

public class AccountController {

    private AccountService accountService = new AccountService();
    private Scanner sc = new Scanner(System.in);

    public void accountMenu() {
        while (true) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. List All Accounts");
            System.out.println("6. Delete Account");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.next();
                    System.out.print("Enter Account Number: ");
                    Long accNo = sc.nextLong();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    accountService.createAccount(name, accNo, balance);
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int depId = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = sc.nextDouble();
                    accountService.deposit(depId, depAmt);
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    int widId = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double widAmt = sc.nextDouble();
                    accountService.withdraw(widId, widAmt);
                    break;

                case 4:
                    System.out.print("Enter Account ID: ");
                    int balId = sc.nextInt();
                    accountService.checkBalance(balId);
                    break;

                case 5:
                    accountService.listAllAccounts();
                    break;

                case 6:
                    System.out.print("Enter Account ID: ");
                    int delId = sc.nextInt();
                    accountService.deleteAccount(delId);
                    break;

                case 7:
                    return; 

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
