package com.it.soul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.soul.mapper.OrderDetailMapper;
import com.it.soul.mapper.OrderMapper;
import com.it.soul.model.OrderDetail;
import com.it.soul.model.Orders;
import com.it.soul.service.OrderDetailService;
import com.it.soul.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
