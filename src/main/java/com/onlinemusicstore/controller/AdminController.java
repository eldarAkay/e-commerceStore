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

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by eldar on 24/12/16.
 */
@Controller
public class AdminController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productsInventory")
    public String getProductInventory(Model model) {
        List<Product> products = productDao.getAll();
        model.addAttribute("products", products);
        return "productsInventory";
    }

    @RequestMapping("/admin/productsInventory/addProduct")
    public String getAddProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping("/admin/productsInventory/editProduct/{id}")
    public String getEditProductPage(@PathVariable String id, Model model) {
        Product product = productDao.get(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productsInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {

        if(result.hasErrors()){
            return "addProduct";
        }

        productDao.add(product);

        MultipartFile image = product.getImage();
        path = Paths.get("/home/eldar/IdeaProjects/onlinemusicstore/images/" + product.getId() + ".jpg");

        if (image != null && !image.isEmpty()) {

            try {
                image.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/productsInventory/addProduct";
    }


    @RequestMapping(value = "/admin/productsInventory/editProduct/", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {

        if(result.hasErrors()){
            return "editProduct";
        }

        productDao.edit(product);

        MultipartFile image = product.getImage();
        path = Paths.get("/home/eldar/IdeaProjects/onlinemusicstore/images/" + product.getId() + ".jpg");

        if (image != null && !image.isEmpty()) {

            try {
                image.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/productsInventory/editProdu";
    }

    @RequestMapping(value = "/admin/productsInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id) {
        productDao.delete(Integer.parseInt(id));

        path = Paths.get("/home/eldar/IdeaProjects/onlinemusicstore/images/" + id + ".jpg");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/productsInventory";
    }
}
