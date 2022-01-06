package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.dao.ProductCategoryDao;
import com.codecool.codecoolshopspring.dao.implementation.ProductCategoryDaoMem;
import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("category", service.getProductCategory(1));
        model.addAttribute("products", service.getProductsForCategory(1));
        return "product/index";
    }

    @GetMapping("/tablets")
    public String displayTablets(Model model) {
        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("category", service.getProductCategory(1));
        model.addAttribute("products", service.getProductsForCategory(1));
        return "product/index";
    }

    @GetMapping("/laptops")
    public String displayLaptops(Model model) {
        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("category", service.getProductCategory(2));
        model.addAttribute("products", service.getProductsForCategory(2));
        return "product/index";
    }

    @GetMapping("/mobiles")
    public String displayMobiles(Model model) {
        model.addAttribute("categories", service.getAllProductCategories());
        model.addAttribute("category", service.getProductCategory(3));
        model.addAttribute("products", service.getProductsForCategory(3));
        return "product/index";
    }
}
