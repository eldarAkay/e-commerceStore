package com.onlinemusicstore.dao.impl;

import com.onlinemusicstore.dao.CartDao;
import com.onlinemusicstore.model.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eldar on 25/12/16.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getId())) {
            throw new IllegalArgumentException("Cart already exist");
        }
        listOfCarts.put(cart.getId(), cart);

        return cart;
    }

    @Override
    public Cart read(String  cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("cart does not exists");
        }
        listOfCarts.put(cartId,cart);
    }

    @Override
    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("cart does not exists");
        }
        listOfCarts.remove(cartId);
    }
}
