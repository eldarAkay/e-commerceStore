package com.onlinemusicstore.service.impl;

import com.onlinemusicstore.dao.CustomerOrderDao;
import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.model.CartItem;
import com.onlinemusicstore.model.CustomerOrder;
import com.onlinemusicstore.service.CartService;
import com.onlinemusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eldar on 04/01/17.
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {

        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item: cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }
}
