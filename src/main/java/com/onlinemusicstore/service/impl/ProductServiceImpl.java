package com.onlinemusicstore.service.impl;

import com.onlinemusicstore.dao.ProductDao;
import com.onlinemusicstore.model.Product;
import com.onlinemusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eldar on 29/12/16.
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Override
    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
