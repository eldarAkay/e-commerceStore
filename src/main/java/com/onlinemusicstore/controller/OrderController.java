package com.onlinemusicstore.controller;

import com.onlinemusicstore.model.Cart;
import com.onlinemusicstore.model.Customer;
import com.onlinemusicstore.model.CustomerOrder;
import com.onlinemusicstore.service.CartService;
import com.onlinemusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eldar on 04/01/17.
 */
@Controller
public class OrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerCustomerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerCustomerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerCustomerOrder.setCustomer(customer);
        customerCustomerOrder.setBillingAddress(customer.getBillingAddress());
        customerCustomerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerCustomerOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
