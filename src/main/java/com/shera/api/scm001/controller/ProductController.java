package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.product.Product;
import com.shera.api.scm001.dao.product.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scm001")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProducts() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public @ResponseBody
    String createProduct(@RequestBody Product productBody) {
        productRepository.save(productBody);
        return "Created";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateProduct(@RequestBody Product productBody, @PathVariable int id) {
        productRepository.save(productBody);
        return "Updated";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "Deleted";
    }
}
