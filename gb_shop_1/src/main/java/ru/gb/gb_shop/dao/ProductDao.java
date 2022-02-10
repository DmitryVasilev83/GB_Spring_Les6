package ru.gb.gb_shop.dao;

import ru.gb.gb_shop.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    Product findById(Long id);
    void delete(Product product);

}
