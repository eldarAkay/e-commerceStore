package com.onlinemusicstore.dao.impl;

import com.onlinemusicstore.dao.CartDao;
import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;

/**
 * Created by eldar on 03/01/17.
 */

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Override
    public Cart getCartById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return (Cart) session.get(Cart.class,id);
    }

    @Override
    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if(cart == null||cart.getCartItems().size()==0){
            throw new IOException(cartId +"");
        }
        update(cart);

        return cart;
    }

    @Override
    public void update(Cart cart) {
        int cartId = cart.getId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }
}
