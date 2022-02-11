package ru.gb.gb_shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.gb_shop.dao.HibernateProductDao;
import ru.gb.gb_shop.entity.Product;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final HibernateProductDao hibernateProductDao;


    public void save(Product product){hibernateProductDao.save(product); }

    public void edit(Product product){hibernateProductDao.update(product); }

    public List<Product> getProductList(){
        return hibernateProductDao.findAll();
    }

    public Product findById(Long id){
        try{
            return hibernateProductDao.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteProductById(Long id){
        hibernateProductDao.delete(hibernateProductDao.findById(id));
    }



}
