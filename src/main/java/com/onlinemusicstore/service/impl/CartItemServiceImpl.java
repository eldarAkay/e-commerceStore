package com.onlinemusicstore.service.impl;

import com.onlinemusicstore.dao.CartItemDao;
import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.model.CartItem;
import com.onlinemusicstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eldar on 03/01/17.
 */
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
       return cartItemDao.getCartItemByProductId(productId);
    }
}
