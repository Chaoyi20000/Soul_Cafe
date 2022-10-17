package com.it.soul;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.soul.controller.CustomerController;
import com.it.soul.model.Cart;
import com.it.soul.model.Customer;
import com.it.soul.model.Product;
import com.it.soul.service.CartService;
import com.it.soul.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestCustomerController {

    @Autowired
    CustomerController customerController;

    @Test
    void testLoginSuccessful(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        Customer c = new Customer();
        c.setUsername("amber");
        c.setPassword("123456");
        String res = customerController.login(request,c).toString();
        Assertions.assertTrue(res.contains("code=200"));
    }

    @Test
    void testLoginFail1(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        Customer c = new Customer();
        c.setUsername("amber");
        //test with wrong password
        c.setPassword("12345");
        String res = customerController.login(request,c).toString();
        Assertions.assertTrue(res.contains("code=0"));
    }

    @Test
    void testLoginFail2(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        Customer c = new Customer();
        //test user not exist
        c.setUsername("notexist");
        c.setPassword("123");
        String res = customerController.login(request,c).toString();
        Assertions.assertTrue(res.contains("code=0"));
    }

    /*@Test
    void testRegisterSuccessful(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        Customer c = new Customer();
        c.setUsername("robbie");
        c.setPassword("12345");
        c.setEmail("robbie@soulcafe.com");
        c.setPhone("0448551080");
        c.setGender("1");
        c.setFirstname("robbie");
        c.setLastname("chen");
        String res = customerController.register(c).toString();
        Assertions.assertTrue(res.contains("code=200"));
    }*/

    @Test
    void testRegisterUnsuccessful(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        Customer c = new Customer();
        //register user already exist
        c.setUsername("amber");
        c.setPassword("12345");
        c.setEmail("robbie@soulcafe.com");
        c.setPhone("0448551080");
        c.setGender("1");
        c.setFirstname("robbie");
        c.setLastname("chen");
        String res = customerController.register(c).toString();
        Assertions.assertTrue(res.contains("code=0"));
    }



}
