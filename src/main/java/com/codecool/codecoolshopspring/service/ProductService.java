package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.dao.ProductCategoryDao;
import com.codecool.codecoolshopspring.dao.ProductDao;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService{
    private ProductDao productDao; //dependency injection
    private ProductCategoryDao productCategoryDao;

    @Autowired
    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryDao.getAll();
    }


}
