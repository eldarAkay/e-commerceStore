package com.onlinemusicstore.controller.admin;

import com.onlinemusicstore.model.Product;
import com.onlinemusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by eldar on 29/12/16.
 */

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    private Path path;

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model){

        Product product = new Product();
        product.setCategory("instrument");
        product.setCondition("new");
        product.setStatus("active");

        model.addAttribute("product",product);

        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct",method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){

            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getImage();
        path = Paths.get("/home/eldar/IdeaProjects/onlinemusicstore/images/" + product.getId() + ".jpg");

        if(productImage != null){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/product/editProduct/{id}",method = RequestMethod.GET)
    public String editProduct(@PathVariable("id") int id,Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product",product);

        return "editProduct";
    }

    @RequestMapping(value = "/product/editProduct",method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product")Product product,BindingResult result){
        if(result.hasErrors()){

            return "editProduct";
        }
        productService.editProduct(product);

        MultipartFile productImage = product.getImage();
        path = Paths.get("/home/eldar/IdeaProjects/onlinemusicstore/images/" + product.getId() + ".jpg");

        if(productImage != null){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id,Model model,HttpServletRequest request){
        path = Paths.get("/home/eldar/IdeaProjects/onlinemusicstore/images/" + id + ".jpg");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProduct(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}
