package com.it.soul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.soul.mapper.OrderMapper;
import com.it.soul.mapper.ProductMapper;
import com.it.soul.model.Orders;
import com.it.soul.model.Product;
import com.it.soul.service.OrderService;
import com.it.soul.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
}
