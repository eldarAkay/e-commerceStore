package com.onlinemusicstore.dao;

import com.onlinemusicstore.model.Cart;
import java.io.IOException;
/**
 * Created by eldar on 25/12/16.
 */
public interface CartDao {

    Cart getCartById(int id);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
}
