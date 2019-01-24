package com.onlinemusicstore.dao;

import com.onlinemusicstore.model.Product;
import java.util.List;

/**
 * Created by eldar on 23/12/16.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProduct(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
