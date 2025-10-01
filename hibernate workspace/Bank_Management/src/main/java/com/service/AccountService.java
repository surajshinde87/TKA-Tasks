package com.service;

import java.util.List;

import com.dao.AccountDAO;
import com.entity.Account;

public class AccountService {

    private AccountDAO accountDAO = new AccountDAO();

    // Create new account
    public void createAccount(String holderName, Long accNo, double initialBalance) {
        Account acc = new Account();
        acc.setAccHolder(holderName);
        acc.setAccNo(accNo);
        acc.setBalance(initialBalance);

        accountDAO.createAccount(acc);
        System.out.println("Account created successfully for " + holderName + " | AccNo: " + accNo);
    }

    //  Deposit
    public void deposit(int accountId, double amount) {
        Account acc = accountDAO.getAccountById(accountId);
        if (acc != null) {
            acc.setBalance(acc.getBalance() + amount);
            accountDAO.updateAccount(acc);
            System.out.println("Deposit of " + amount + " successful. New Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    // 3. Withdraw
    public void withdraw(int accountId, double amount) {
        Account acc = accountDAO.getAccountById(accountId);
        if (acc != null) {
            if (acc.getBalance() >= amount) {
                acc.setBalance(acc.getBalance() - amount);
                accountDAO.updateAccount(acc);
                System.out.println("Withdrawal of " + amount + " successful. New Balance: " + acc.getBalance());
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    //  Check Balance
    public void checkBalance(int accountId) {
        Account acc = accountDAO.getAccountById(accountId);
        if (acc != null) {
            System.out.println("Balance for Account ID " + accountId + " is: " + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    // List all accounts
    public void listAllAccounts() {
        List<Account> accounts = accountDAO.getAllAccounts();
        System.out.println("\n All Accounts:");
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    //  Delete account
    public void deleteAccount(int accountId) {
        Account acc = accountDAO.getAccountById(accountId);
        if (acc != null) {
            accountDAO.deleteAccount(accountId);
            System.out.println("Account with ID " + accountId + " deleted.");
        } else {
            System.out.println("Account not found!");
        }
    }
}
