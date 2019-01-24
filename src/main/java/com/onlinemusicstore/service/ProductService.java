package com.onlinemusicstore.service;

import com.onlinemusicstore.model.Product;
import java.util.List;
import java.util.PropertyPermission;

/**
 * Created by eldar on 29/12/16.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProduct(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
