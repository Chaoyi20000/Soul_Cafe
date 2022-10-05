package com.it.soul.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.soul.common.R;
import com.it.soul.composite.OrderDto;
import com.it.soul.model.Cart;
import com.it.soul.model.Customer;
import com.it.soul.model.OrderDetail;
import com.it.soul.model.Orders;
import com.it.soul.service.CartService;
import com.it.soul.service.CustomerService;
import com.it.soul.service.OrderDetailService;
import com.it.soul.service.OrderService;
import com.it.soul.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Transactional
    @PostMapping
    public R<String> checkout(@RequestBody OrderDto orderInfo, @RequestParam String token){

        System.out.println(orderInfo);

       Customer customer = TokenUtils.getCustomer(token);
        Long customerId = customer.getId();

        Orders order = new Orders();
        order.setCustomerName(customer.getFirstname() + " " +customer.getLastname());
        order.setPhone(customer.getPhone());
        order.setStatus(1);
        order.setCustomerId(customerId);
        order.setOrderTime(LocalDateTime.now());
        order.setRemark(orderInfo.getRemark());
        BigDecimal subtotal = new BigDecimal(0);

        LambdaQueryWrapper<Cart> qw = new LambdaQueryWrapper<>();
        qw.eq(Cart::getCustomerId, customerId);
        List<Cart> products = cartService.list(qw);


        for(Cart product: products){
            subtotal = subtotal.add(product.getAmount().multiply(new BigDecimal(product.getQuantity())));
        }

        Integer orderNumber = orderService.count() + 1;
        order.setNumber(orderNumber);
        order.setTotal(subtotal);
        orderService.save(order);

        for(Cart product: products){
            List<OrderDetail> orderDetails = new ArrayList<>();

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderNumber);
            orderDetail.setProductName(product.getProductName());
            orderDetail.setSize(product.getSize());
            if(product.getExtra().isEmpty()){
                orderDetail.setExtra("no base");
            }else{
                orderDetail.setExtra(product.getExtra());
            }
            orderDetail.setAmount(product.getAmount());
            orderDetail.setQuantity(product.getQuantity());
            orderDetail.setProductId(product.getProductId());
            orderDetails.add(orderDetail);

            orderDetailService.saveBatch(orderDetails);
        }

        cartService.remove(qw);
        customer.setCredit(customer.getCredit() + subtotal.intValue());
        customerService.updateById(customer);


        return R.success("Place order successfully");
    }

    @GetMapping
    public R<List<Orders>> getOrders(Long customerId, int page, int size){
        Page<Orders> orders = new Page<>(page,size);
        LambdaQueryWrapper<Orders> qw = new LambdaQueryWrapper<>();
        qw.eq(Orders::getCustomerId, customerId);
        qw.orderByDesc(Orders::getUpdateTime);
        orderService.page(orders,qw);

        List<Orders> ordersList = orders.getRecords();

        for (Orders order : ordersList) {
            LambdaQueryWrapper<OrderDetail> qw2 = new LambdaQueryWrapper<>();
            qw2.eq(OrderDetail::getOrderId, order.getNumber());
            List<OrderDetail> orderDetails = orderDetailService.list(qw2);
            order.setOrderDetails(orderDetails);
        }

        return R.success(ordersList);
    }

}
