package com.onlinemusicstore.model;

/**
 * Created by eldar on 25/12/16.
 */
public class CartItem {

    private Product product;
    private int quantity;
    private double totalPrice;

    public CartItem() {

    }

    public CartItem(Product product, int quantity, double totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
