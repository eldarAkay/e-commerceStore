package com.onlinemusicstore.controller;

import com.onlinemusicstore.model.BillingAddress;
import com.onlinemusicstore.model.Customer;
import com.onlinemusicstore.model.Product;
import com.onlinemusicstore.model.ShippingAddress;
import com.onlinemusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by eldar on 31/12/16.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public String registerCustomer(Model model){

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();

        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer",customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public String registerCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult result,Model model){

        if(result.hasErrors()){

            return "registerCustomer";
        }

        List<Customer> customerList = customerService.getAll();


        if(customerList.stream().anyMatch((c)->c.getUserName().contains(customer.getUserName()))){
            model.addAttribute("userNameMsg","UserName already exists");

            return "registerCustomer";
        }

        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";
    }
}
