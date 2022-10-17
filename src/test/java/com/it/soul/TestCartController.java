package com.it.soul;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.soul.controller.CartController;
import com.it.soul.controller.CustomerController;
import com.it.soul.model.Cart;
import com.it.soul.model.Customer;
import com.it.soul.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestCartController {

    @Autowired
    CartController cartController;

    @Autowired
    CartService cartService;

    @Test
    void testAddCartSuccessful(){
        Cart c = new Cart();
        c.setProductName("Espresso");
        c.setCustomerId(1L);
        c.setProductId(3L);
        c.setSize("small");
        c.setExtra("milk");
        c.setAmount(new BigDecimal("3.50"));
        String res = cartController.addCart(c).toString();
        Assertions.assertTrue(res.contains("code=200"));
    }

    @Test
    void testUpdateCartSuccessful(){
        Cart c = new Cart();
        c.setId(1572002448162185218L);
        c.setProductName("Espresso");
        c.setCustomerId(1570168165902635009L);
        c.setProductId(3L);
        c.setSize("large");
        c.setExtra("milk");
        c.setAmount(new BigDecimal("7.00"));
        String res = cartController.changeCart(c).toString();
        Assertions.assertTrue(res.contains("code=200"));
    }

    /*@Test
    void testGetCartCorrect(){
        LambdaQueryWrapper<Cart> qw = new LambdaQueryWrapper<>();
        qw.eq(Cart::getCustomerId, 1572110413917712386L);
        String res = cartService.list(qw).toString();
        String expected = "[Cart(id=1572491458717745153, productName=Mocha, image=null, customerId=1572110413917712386, productId=6, size=medium, extra=full cream, quantity=3, amount=3.30, createTime=2022-09-21T07:42:34, updateTime=2022-09-21T08:13:58)]";
        Assertions.assertEquals(expected, res);
    }*/
}
