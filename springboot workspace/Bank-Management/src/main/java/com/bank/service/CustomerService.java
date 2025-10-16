package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.CustomerDao;
import com.bank.entities.Customer;

@Service
public class CustomerService {

	 @Autowired
	    private CustomerDao customerDao;

	    public List<Customer> getAllCustomers() {
	        return customerDao.findAll();
	    }

	    public Customer getCustomerById(Integer id) {
	        return customerDao.findById(id).orElse(null);
	    }

	    public Customer addCustomer(Customer customer) {
	        return customerDao.save(customer);
	    }

	    public void deleteCustomer(Integer id) {
	        customerDao.deleteById(id);
	    }
	
}
