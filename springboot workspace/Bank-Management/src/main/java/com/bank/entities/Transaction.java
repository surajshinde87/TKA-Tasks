package com.bank.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Transaction {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String transactionType;  //  DEPOSIT, WITHDRAWAL
	    private Double amount;
	    private LocalDateTime timestamp;
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "account_id")
	    private Account account;

		public Transaction() {
			super();
		}

		public Transaction(Integer id, String transactionType, Double amount, LocalDateTime timestamp,
				String description, Account account) {
			super();
			this.id = id;
			this.transactionType = transactionType;
			this.amount = amount;
			this.timestamp = timestamp;
			this.description = description;
			this.account = account;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}

		@Override
		public String toString() {
			return "Transaction [id=" + id + ", transactionType=" + transactionType + ", amount=" + amount
					+ ", timestamp=" + timestamp + ", description=" + description + ", account=" + account + "]";
		}
		
		
	    
	    

}
