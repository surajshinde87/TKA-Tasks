package com.service;

import com.dao.CustomerDAO;
import com.entity.Customer;

public class CustomerService {
    private CustomerDAO cd = new CustomerDAO();

    public void addCustomer(Customer c) {
        cd.addCustomer(c);
    }

    public Customer getCustomer(int id) {
        return cd.getCustomer(id);
    }
}
