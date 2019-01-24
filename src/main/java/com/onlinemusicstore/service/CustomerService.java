package com.onlinemusicstore.service;

import com.onlinemusicstore.model.Customer;

import java.util.List;

/**
 * Created by eldar on 31/12/16.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    Customer getCustomerByUserName(String name);

    List<Customer> getAll();
}
