package com.onlinemusicstore.service;

import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.model.CartItem;

/**
 * Created by eldar on 03/01/17.
 */
public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
