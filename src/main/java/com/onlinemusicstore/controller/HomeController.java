package com.onlinemusicstore.controller;

import com.onlinemusicstore.dao.ProductDao;
import com.onlinemusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.ModalExclude;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by eldar on 21/12/16.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String getHello() {
        return "home";
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = productDao.getAll();
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("products/viewProduct/{id}")
    public String viewProduct(@PathVariable String id, Model model) {

        Product product = productDao.get(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "viewProduct";
    }



}
