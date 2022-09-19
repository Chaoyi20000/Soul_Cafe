package com.it.soul;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.soul.common.R;
import com.it.soul.controller.ProductController;
import com.it.soul.model.Cart;
import com.it.soul.model.Product;
import com.it.soul.service.CartService;
import com.it.soul.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestingWebApplicationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;


    @Test
    void testProductCorrect(){
        List<Product> products = productService.list();
        String expected = "[Product(id=1, name=Americano, categoryId=1, price=2.50, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=2, name=Cappuccino, categoryId=1, price=2.50, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=3, name=Espresso, categoryId=1, price=2.50, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=4, name=Macchiato, categoryId=1, price=2.80, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=5, name=Latte, categoryId=1, price=2.80, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=6, name=Mocha, categoryId=1, price=2.80, calorie=300, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=7, name=Jasmine Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=8, name=Green Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=9, name=Ginger Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=10, name=Black Tea, categoryId=2, price=2.80, calorie=200, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=11, name=Mango Passionfruit, categoryId=3, price=3.00, calorie=450, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=12, name=Raspberry Blackcurrant, categoryId=3, price=3.00, calorie=450, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=13, name=Donut Cookie, categoryId=4, price=2.80, calorie=500, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43), Product(id=14, name=Caramel Slice, categoryId=4, price=2.80, calorie=500, image=1.jpg, description=, status=1, sort=0, createTime=2021-05-27T09:38:43, updateTime=2021-05-27T09:38:43)]";
        assertEquals(expected, products.toString());
    }

    @Test
    void testUserCartCorrect(){
        LambdaQueryWrapper<Cart> qw = new LambdaQueryWrapper<>();
        qw.eq(Cart::getCustomerId, 1);
        List<Cart> carts = cartService.list(qw);
        String expected = "[Cart(id=1570257616755175425, productName=Raspberry Blackcurrant, image=null, customerId=1, productId=12, size=small, extra=, quantity=1, amount=3.00, createTime=2022-09-15T13:46:04, updateTime=2022-09-15T13:46:04)]";
        assertEquals(expected, carts.toString());
    }
}
