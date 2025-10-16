package com.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entities.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByAccountId(Integer accountId);
	
}
