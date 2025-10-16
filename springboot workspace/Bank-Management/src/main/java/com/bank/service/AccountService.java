package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDao;
import com.bank.entities.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public List<Account> getAllAccounts(){
		return accountDao.findAll();
	}
	
	public Account getAccountById(Integer id) {
		return accountDao.findById(id).orElse(null);
	}
	
	public List<Account> getAccountByCustomerId(Integer customerId) {
		return accountDao.findByCustomerId(customerId);
	}
	
	public Account addAccount(Account account) {
		return accountDao.save(account);
	}
	public void deleteAccount(Integer id) {
		accountDao.deleteById(id);
	}
	
}
