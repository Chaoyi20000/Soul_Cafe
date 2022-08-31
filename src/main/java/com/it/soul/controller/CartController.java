package com.it.soul.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.soul.common.R;
import com.it.soul.model.Cart;
import com.it.soul.model.Product;
import com.it.soul.service.CartService;
import com.it.soul.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public R<String> addCart(@RequestBody Cart cart){

        LambdaQueryWrapper<Cart> qw = new LambdaQueryWrapper<>();
        qw = qw.eq(Cart::getProductName, cart.getProductName()).eq(Cart::getExtra, cart.getExtra());
        Cart exist = cartService.getOne(qw);

        if(exist != null){
            exist.setQuantity(exist.getQuantity() + 1);
            cartService.updateById(exist);
        }else{
            cart.setQuantity(1);
            cartService.save(cart);
        }

        return R.success("Add to cart successfully");
    }

}
