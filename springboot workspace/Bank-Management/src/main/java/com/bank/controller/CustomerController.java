package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entities.Customer;
import com.bank.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/add-customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		 System.out.println("Received Customer: " + customer);
		return customerService.addCustomer(customer);
	}

	@GetMapping("/by-id/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}

	@GetMapping("all-customer")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }
	
}
