package com.onlinemusicstore.service;

import com.onlinemusicstore.model.CustomerOrder;

/**
 * Created by eldar on 04/01/17.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
