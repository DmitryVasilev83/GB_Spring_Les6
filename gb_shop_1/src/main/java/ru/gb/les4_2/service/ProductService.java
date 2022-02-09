package ru.gb.les4_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.les4_2.model.Product;
import ru.gb.les4_2.repozitory.ProductRepository;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public Product save(Product product){return productRepository.save(product); }

    public Product edit(Product product){return productRepository.edit(product); }

    public List<Product> getProductList(){
        return productRepository.getProducts();
    }

    public Product findProductById(Integer id){
        return productRepository.findProductById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteProductById(Integer id){productRepository.deleteProductByID(id);
    }



}
