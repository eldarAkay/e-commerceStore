package com.onlinemusicstore.controller;

import com.onlinemusicstore.model.Customer;
import com.onlinemusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eldar on 03/01/17.
 */

@Controller
@RequestMapping("customer/cart")
public class CartController {
    private final CustomerService customerService;

    @Autowired
    public CartController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
        int cartId = customer.getCart().getId();

        return "redirect:/customer/cart/"+cartId;
    }

    @RequestMapping(value = "/{id}")
    public String getCart(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("cartId",id);

        return "cart";
    }
}
