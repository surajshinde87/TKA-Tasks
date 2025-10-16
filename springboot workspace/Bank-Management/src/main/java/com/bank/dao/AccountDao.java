package com.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entities.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

	List<Account> findByCustomerId(Integer customerId);
	
}
