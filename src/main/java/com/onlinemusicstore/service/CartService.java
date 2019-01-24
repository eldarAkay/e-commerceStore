package com.onlinemusicstore.service;

import com.onlinemusicstore.model.Cart;

/**
 * Created by eldar on 03/01/17.
 */
public interface CartService {

    Cart getCartById(int id);

    void update(Cart cart);
}
