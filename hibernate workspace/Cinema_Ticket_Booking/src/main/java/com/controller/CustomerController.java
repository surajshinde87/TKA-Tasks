package com.controller;

import com.entity.Customer;
import com.service.CustomerService;

public class CustomerController {
    private CustomerService cs = new CustomerService();

    public void addCustomer(String name) {
        Customer c = new Customer();
        c.setName(name);
        cs.addCustomer(c);
        System.out.println("Customer added: " + name);
    }

    public Customer getCustomer(int id) {
        return cs.getCustomer(id);
    }
}
