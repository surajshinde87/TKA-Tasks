package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String accHolder;
	private Long accNo;
	private double balance;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Transactions> transactions;
	
	public Account() {
		
	}

	public Account(int id, String accHolder, Long accNo, double balance, List<Transactions> transactions) {
		super();
		this.id = id;
		this.accHolder = accHolder;
		this.accNo = accNo;
		this.balance = balance;
		this.transactions = transactions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
	    return "Account [id=" + id + ", accHolder=" + accHolder + ", accNo=" + accNo + ", balance=" + balance + "]";
	}

	
	
	

}
