package com.onlinemusicstore.dao;

import com.onlinemusicstore.model.Customer;
import java.util.List;

/**
 * Created by eldar on 31/12/16.
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    Customer getCustomerByName(String name);

    List<Customer> getAll();
}
