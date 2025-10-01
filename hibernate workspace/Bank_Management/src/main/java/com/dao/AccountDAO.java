package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entity.Account;
import com.entity.Transactions;


public class AccountDAO {

	public void createAccount(Account account) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Transactions.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.persist(account);
		
		tr.commit();
		ss.close();
	}
	
	
public Account getAccountById(int id){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Account.class);
	cfg.addAnnotatedClass(Transactions.class);

	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();
	Transaction tr = ss.beginTransaction();
	
	String hql = "from Account where id = :id";
	Query<Account> query  = ss.createQuery(hql, Account.class);
	query.setParameter("id", id);
	
	Account acc= query.uniqueResult();
	
	tr.commit();
	ss.close();
	
	return acc;
}

public List<Account> getAllAccounts(){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Account.class);
	cfg.addAnnotatedClass(Transactions.class);

	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();
	Transaction tr = ss.beginTransaction();
	
	String hql = "from Account";
	
	Query<Account> query  = ss.createQuery(hql, Account.class);
	 
	List<Account> accounts  = query.list();
	
	
	tr.commit();
	ss.close();
	
	return accounts;
	
}

public void updateAccount(Account acc){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Account.class);
	cfg.addAnnotatedClass(Transactions.class);

	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();
	Transaction tr = ss.beginTransaction();
	
	ss.merge(acc);
	
	tr.commit();
	ss.close();
}

public void deleteAccount(int id){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Account.class);
	cfg.addAnnotatedClass(Transactions.class);

	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();
	Transaction tr = ss.beginTransaction();
	
	String hql = "delete from Account where id = :id";
	
	MutationQuery query = ss.createMutationQuery(hql);  
	query.setParameter("id", id);
	query.executeUpdate(); 
	
	System.out.println("data is Deleted...");
	
	tr.commit();
	ss.close();
	
	
}

}
