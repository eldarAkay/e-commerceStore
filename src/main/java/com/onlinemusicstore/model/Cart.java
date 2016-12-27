package com.onlinemusicstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eldar on 25/12/16.
 */
public class Cart {

    private String id;
    private Map<Integer,CartItem> cartItems;
    private double grandTotal;

    public Cart() {
        this.cartItems = new HashMap<>();
        this.grandTotal = 0;
    }

    public Cart(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void addCartItem(CartItem item){

        int productId = item.getProduct().getId();

        if(cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId,existingCartItem);
        } else {
            cartItems.put(productId,item);
        }

        updateGrandTotal();

    }

    public void removeCartItem(CartItem item){
        int productId = item.getProduct().getId();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    private void updateGrandTotal() {
        grandTotal = 0;
        for(CartItem item: cartItems.values()){
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }
}
