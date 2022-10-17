package com.it.soul.controller;


import com.it.soul.common.R;
import com.it.soul.model.Product;
import com.it.soul.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public R<List<Product>> getAllProducts(){
        List<Product> products = productService.list();
        return R.success(products);
    }

}
