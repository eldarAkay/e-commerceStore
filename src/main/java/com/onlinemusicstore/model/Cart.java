package com.onlinemusicstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eldar on 25/12/16.
 */
public class Cart {

    private int id;
    private Map<Integer,CartItem> cartItems;
    private double grandTotal;

    public Cart() {

        this.cartItems = new HashMap<>();
        this.grandTotal = 0;
    }

    public Cart(int id) {
        this();
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }


}
