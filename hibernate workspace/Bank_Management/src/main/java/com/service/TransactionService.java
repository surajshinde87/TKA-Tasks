package com.service;

import com.dao.TransactionDAO;
import com.dao.AccountDAO;
import com.entity.Transactions;
import com.entity.Account;

import java.time.LocalDate;
import java.util.List;

public class TransactionService {

    private TransactionDAO transactionDAO = new TransactionDAO();
    private AccountDAO accountDAO = new AccountDAO();

    // Add transaction (Deposit or Withdraw)
    public void addTransaction(int accountId, String type, double amount) {
        Account acc = accountDAO.getAccountById(accountId);

        if (acc != null) {
            Transactions txn = new Transactions();
            txn.setType(type);
            txn.setAmount(amount);
            txn.setTimestamp(LocalDate.now());
            txn.setAccount(acc);

            transactionDAO.saveTransaction(txn);
            System.out.println("Transaction saved: " + type + " of " + amount + " for Account ID " + accountId);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Show all transactions of a particular account
    public void listTransactionsByAccount(int accountId) {
        List<Transactions> txns = transactionDAO.getTransactionsByAccountId(accountId);
        if (txns.isEmpty()) {
            System.out.println("No transactions found for account " + accountId);
        } else {
            System.out.println("\n Transactions for Account " + accountId + ":");
            for (Transactions t : txns) {
            	 System.out.println(t);
            }
        }
    }

    // Show all transactions in system
    public void listAllTransactions() {
        List<Transactions> txns = transactionDAO.getAllTransactions();
        if (txns.isEmpty()) {
            System.out.println("No transactions found in the system.");
        } else {
            System.out.println("\n All Transactions:");
            for (Transactions t : txns) {
              System.out.println(t);
            }
        }
    }
}
