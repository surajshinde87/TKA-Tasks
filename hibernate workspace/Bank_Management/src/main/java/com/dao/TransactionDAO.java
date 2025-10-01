package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Transactions; 
import com.entity.Account;

public class TransactionDAO {

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Transactions.class);
        cfg.addAnnotatedClass(Account.class);
        return cfg.buildSessionFactory();
    }

    public void saveTransaction(Transactions txn) {
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        ss.persist(txn);

        tr.commit();
        ss.close();
        sf.close();
    }


    public List<Transactions> getTransactionsByAccountId(int accountId) {
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();

        String hql = "from Transactions where account.id = :accId order by timestamp DESC";
        Query<Transactions> query = ss.createQuery(hql, Transactions.class);
        query.setParameter("accId", accountId);

        List<Transactions> transactions = query.list();

        ss.close();
        sf.close();
        return transactions;
    }

    
    public List<Transactions> getAllTransactions() {
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();

        String hql = "from Transactions";
        Query<Transactions> query = ss.createQuery(hql, Transactions.class);
        List<Transactions> transactions = query.list();

        ss.close();
        sf.close();
        return transactions;
    }
}
