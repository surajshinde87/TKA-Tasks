package com.bank.service;

import com.bank.dao.TransactionDao;
import com.bank.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    public List<Transaction> getAllTransactions() {
        return transactionDao.findAll();
    }

    public Transaction getTransactionById(Integer id) {
        return transactionDao.findById(id).orElse(null);
    }

    public List<Transaction> getTransactionsByAccountId(Integer accountId) {
        return transactionDao.findByAccountId(accountId);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionDao.save(transaction);
    }

    public void deleteTransaction(Integer id) {
        transactionDao.deleteById(id);
    }
}
