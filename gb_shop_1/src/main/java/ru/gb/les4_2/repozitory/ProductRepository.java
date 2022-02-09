package ru.gb.les4_2.repozitory;


import org.springframework.stereotype.Component;
import ru.gb.les4_2.model.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("product")
public class ProductRepository {

    List<Product> products = new ArrayList<>();

    private int count = 0;

    public Product save(Product product){
        product.setId(count++);
        products.add(product);


        // заворачиваем в билдер(из ломбока) для безопасности. ВОзвращаем не само сообщение а его копию

        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    public Product edit(Product product){
        return products.set(product.getId(), product);
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products);
    }

    public Optional<Product> findProductById(Integer id){
        if (id < products.size()){
            return Optional.of(products.get(id));
        }else {
            return Optional.empty();
        }
    }

    public void deleteProductByID(Integer id){
        if (id < products.size()){
            products.remove(id.intValue());
        }
    }

}
