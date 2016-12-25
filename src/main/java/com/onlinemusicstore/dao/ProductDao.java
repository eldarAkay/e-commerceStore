package com.onlinemusicstore.dao;

import com.onlinemusicstore.model.Product;

import java.util.List;

/**
 * Created by eldar on 23/12/16.
 */
public interface ProductDao {

    void add(Product product);

    void edit(Product product);

    Product get(int id);

    List<Product> getAll();

    void delete(int id);
}
