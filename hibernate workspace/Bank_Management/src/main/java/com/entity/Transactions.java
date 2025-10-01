package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;  // Deposit or Withdraw
	private double amount;
	private LocalDate timestamp;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	
	public Transactions() {
	}


	public Transactions(int id, String type, double amount, LocalDate timestamp, Account account) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.timestamp = timestamp;
		this.account = account;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", amount=" + amount + ", timestamp=" + timestamp
				+ ", account=" + account + "]";
	}
	
	
	
}
