package com.bank.controller;

import com.bank.entities.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("get-all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/by-id/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getAccountsByCustomerId(@PathVariable Integer customerId) {
        return accountService.getAccountByCustomerId(customerId);
    }

    @PostMapping("/add-account")
    public Account addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }
}
