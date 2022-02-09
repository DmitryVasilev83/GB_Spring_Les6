package ru.gb.les4_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.les4_2.model.Product;
import ru.gb.les4_2.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // форма для создания product
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    // Обработка формы создания и редактирования product
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createForm(Product product){
        if (product.getId()==null){
            productService.save(product);
        }else {
            productService.edit(product);
        }
        return "redirect:/product/all";
    }

    // показать все элементы productList
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String showProductList(Model model){
        model.addAttribute("products", productService.getProductList());
        System.out.println("test" + productService.getProductList().get(0));
        return "product-list";
    }

    // показать один элемент
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Integer id) {
        Product product;
        product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    // удаление элемента  "/message/delete{id}"
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteProductById(@RequestParam Integer id){

        return "redirect:/product/all";
    }




}
