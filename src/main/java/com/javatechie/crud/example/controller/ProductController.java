package com.javatechie.crud.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
    	Product product = new Product();
        model.addAttribute("product", product);
    	return "addProduct";
    }

    @PostMapping(value = "/addProducts",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addProducts(Product products) {
    	service.saveProducts(products);
    	return "redirect:/products";
    }

    @GetMapping("/products")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.getProducts();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
    
    @GetMapping("/productById/{id}")
    public String findProductById(@PathVariable int id,Model model) {
    	Product product =  service.getProductById(id);
    	model.addAttribute("product", product);
        return "update_employee";
    }

    @RequestMapping("/search")
    public String findProductByName(Model model, @Param("keyword") String keyword) {
    	List<Product> listProducts = service.getProductByName(keyword);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProduct(Product product) {
        Product product1 =  service.updateProduct(product);
        if (product1 == null) {
        	
        	return "redirect:/productById/"+product.getId();
        }
        return "redirect:/products";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
       service.deleteProduct(id);
       return "redirect:/products";
    }
}