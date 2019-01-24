package com.onlinemusicstore.dao.impl;

import com.onlinemusicstore.dao.CustomerDao;
import com.onlinemusicstore.model.Authorities;
import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.model.Customer;
import com.onlinemusicstore.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by eldar on 03/01/17.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setName(customer.getUserName());
        newUser.setEnabled(true);
        newUser.setPassword(customer.getPassword());
        newUser.setCustomerId(customer.getId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUserName(customer.getUserName());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(cart);

        session.flush();
    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        return (Customer) session.get(Customer.class,id);
    }

    @Override
    public Customer getCustomerByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.Query query = session.createQuery("from Customer where userName = ?");
        query.setString(0,name);

        return (Customer) query.uniqueResult();
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }
}
