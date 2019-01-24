package com.onlinemusicstore.controller;

import com.onlinemusicstore.model.Product;
import com.onlinemusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Created by eldar on 29/12/16.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
     public String getProducts(Model model){
         List<Product> products = productService.getProductList();
         model.addAttribute("products",products);
         return "products";
     }

     @RequestMapping("/viewProduct/{id}")
     public String viewProduct(@PathVariable("id") int id,Model model){

         Product product = productService.getProduct(id);
         model.addAttribute("product",product);

         return "viewProduct";
     }
}
