package com.onlinemusicstore.service.impl;

import com.onlinemusicstore.dao.CustomerDao;
import com.onlinemusicstore.model.Customer;
import com.onlinemusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eldar on 31/12/16.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomer(int id)
    {
        return customerDao.getCustomer(id);
    }

    @Override
    public Customer getCustomerByUserName(String name) {
        return customerDao.getCustomerByName(name);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
