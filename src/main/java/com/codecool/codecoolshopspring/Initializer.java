package com.codecool.codecoolshopspring;

import com.codecool.codecoolshopspring.dao.ProductCategoryDao;
import com.codecool.codecoolshopspring.dao.ProductDao;
import com.codecool.codecoolshopspring.dao.SupplierDao;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.Supplier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class Initializer {

    private final ProductDao productDao;
    private final ProductCategoryDao productCategoryDao;
    private final SupplierDao supplierDao;

    public Initializer(ProductDao productDao, ProductCategoryDao productCategoryDao, SupplierDao supplierDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.supplierDao = supplierDao;
    }

    @PostConstruct
    public void init() {
        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDao.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDao.add(lenovo);
        Supplier apple = new Supplier("Apple", "Computers");
        supplierDao.add(apple);
        Supplier dell = new Supplier("Dell", "Computers");
        supplierDao.add(dell);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDao.add(tablet);
        ProductCategory laptop = new ProductCategory("Laptop", "Hardware", "A compact, foldable computer with a full keyboard and display screen that can fit in a person's lap.");
        productCategoryDao.add(laptop);
        ProductCategory mobile = new ProductCategory("Mobile", "Hardware", "A cell phone.");
        productCategoryDao.add(mobile);



        //setting up products and printing it
        productDao.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDao.add(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDao.add(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productDao.add(new Product("Lenovo ThinkPad 470", new BigDecimal("989.9"), "USD", "Lenovo's lightning fast laptop built for heavy duty work use.", laptop, lenovo));
        productDao.add(new Product("Apple MacBook Pro", new BigDecimal("1799.9"), "USD", "Apple's signature laptop, top of the line standard for work and home use.", laptop, apple));
        productDao.add(new Product("Dell TurboCalc Plus", new BigDecimal("765.9"), "USD", "Dell's newest laptop -- it's not great.", laptop, dell));
        productDao.add(new Product("Apple iPhone 12", new BigDecimal("1000.9"), "USD", "The iPhone, a classic.", mobile, apple));
        productDao.add(new Product("Amazon firePhone", new BigDecimal("765.9"), "USD", "Omg, it's like a kindle....but a phone.", mobile, amazon));
        productDao.add(new Product("Lenovo LightPhone", new BigDecimal("599.9"), "USD", "Lenovo's new phone. You probably shouldn't buy it.", mobile, lenovo));

    }
}
