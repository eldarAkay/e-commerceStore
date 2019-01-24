package com.onlinemusicstore.service.impl;

import com.onlinemusicstore.dao.CartDao;
import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eldar on 03/01/17.
 */
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int id) {
        return cartDao.getCartById(id);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
