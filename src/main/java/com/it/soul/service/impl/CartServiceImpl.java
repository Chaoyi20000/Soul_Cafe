package com.it.soul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.soul.mapper.CartMapper;
import com.it.soul.model.Cart;
import com.it.soul.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
}
