package com.it.soul;


import com.it.soul.controller.CartController;
import com.it.soul.controller.ProductController;
import com.it.soul.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestProductController {

    @Autowired
    ProductController productController;

    @Test
    void testProductCorrect(){
        List<Product> products = productController.getAllProducts().getData();
        String expected = "[Product(id=1, name=Americano, categoryId=1, price=2.50, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=2, name=Cappuccino, categoryId=1, price=2.50, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=3, name=Espresso, categoryId=1, price=2.50, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=4, name=Macchiato, categoryId=1, price=2.80, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=5, name=Latte, categoryId=1, price=2.80, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=6, name=Mocha, categoryId=1, price=2.80, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=7, name=Jasmine Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=8, name=Green Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=9, name=Ginger Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=10, name=Black Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=11, name=Passionfruit, categoryId=3, price=3.00, calorie=450, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=12, name=Blackcurrant, categoryId=3, price=3.00, calorie=450, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=13, name=Donut Cookie, categoryId=4, price=2.80, calorie=500, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=14, name=Caramel Slice, categoryId=4, price=2.80, calorie=500, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43)]";
        Assertions.assertEquals(expected, products.toString());
    }

}
