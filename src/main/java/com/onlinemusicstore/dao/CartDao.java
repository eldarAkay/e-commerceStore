package com.onlinemusicstore.dao;

import com.onlinemusicstore.model.Cart;

/**
 * Created by eldar on 25/12/16.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId,Cart cart);

    void delete(String cartId);
}
