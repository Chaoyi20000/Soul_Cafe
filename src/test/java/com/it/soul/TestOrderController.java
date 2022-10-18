package com.it.soul;


import com.it.soul.controller.OrderController;
import com.it.soul.controller.ProductController;
import com.it.soul.model.Orders;
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
public class TestOrderController {


    @Autowired
    OrderController orderController;

    @Test
    void testOrderCorrect(){
        List<Orders> orders1 = orderController.getOrders(1L, 1, 4).getData();
        List<Orders> orders2 = orderController.getOrders(1L, 2, 4).getData();
        List<Orders> empty = orderController.getOrders(1L, 100, 4).getData();

        String expected1 = "[Orders(id=1581924227878735873, number=25, status=2, customerId=1, orderTime=2022-10-17T19:25:01, pay_method=null, total=51.80, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1581924230101716993, productName=Espresso, image=null, orderId=25, productId=3, size=small, extra=milk, quantity=14, amount=3.50, createTime=2022-10-17T19:25:02, updateTime=2022-10-17T19:25:02), OrderDetail(id=1581924232240812034, productName=Macchiato, image=null, orderId=25, productId=4, size=small, extra=no base, quantity=1, amount=2.80, createTime=2022-10-17T19:25:02, updateTime=2022-10-17T19:25:02)], createTime=2022-10-17T19:25:01, updateTime=2022-10-17T19:25:12), Orders(id=1580153025262661633, number=20, status=2, customerId=1, orderTime=2022-10-12T22:06:53, pay_method=null, total=2.80, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1580153027284316162, productName=Jasmine Tea, image=null, orderId=20, productId=7, size=small, extra=no base, quantity=1, amount=2.80, createTime=2022-10-12T22:06:54, updateTime=2022-10-12T22:06:54)], createTime=2022-10-12T22:06:54, updateTime=2022-10-12T22:06:59), Orders(id=1577617553407827970, number=13, status=1, customerId=1, orderTime=2022-10-05T22:11:50, pay_method=null, total=2.50, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1577617555383345154, productName=Americano, image=null, orderId=13, productId=1, size=small, extra=no base, quantity=1, amount=2.50, createTime=2022-10-05T22:11:51, updateTime=2022-10-05T22:11:51)], createTime=2022-10-05T22:11:50, updateTime=2022-10-05T22:11:50), Orders(id=1572491007428866049, number=12, status=2, customerId=1, orderTime=2022-09-21T17:40:46, pay_method=null, total=8.40, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1572491009588932609, productName=Green Tea, image=null, orderId=12, productId=8, size=small, extra=, quantity=3, amount=2.80, createTime=2022-09-21T17:40:47, updateTime=2022-09-21T17:40:47)], createTime=2022-09-21T17:40:46, updateTime=2022-09-21T17:40:46)]";
        String expected2 = "[Orders(id=1572106047970811906, number=10, status=2, customerId=1, orderTime=2022-09-20T16:11:04, pay_method=null, total=7.80, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1572106049984077826, productName=Caramel Slice, image=null, orderId=10, productId=14, size=small, extra=, quantity=1, amount=2.80, createTime=2022-09-20T16:11:05, updateTime=2022-09-20T16:11:05), OrderDetail(id=1572106051993149442, productName=Espresso, image=null, orderId=10, productId=3, size=small, extra=, quantity=2, amount=2.50, createTime=2022-09-20T16:11:06, updateTime=2022-09-20T16:11:06)], createTime=2022-09-20T16:11:05, updateTime=2022-09-20T16:11:05), Orders(id=1572105352551014401, number=9, status=2, customerId=1, orderTime=2022-09-20T16:08:19, pay_method=null, total=2.50, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1572105354568474626, productName=Americano, image=null, orderId=9, productId=1, size=small, extra=, quantity=1, amount=2.50, createTime=2022-09-20T16:08:19, updateTime=2022-09-20T16:08:19)], createTime=2022-09-20T16:08:19, updateTime=2022-09-20T16:08:19), Orders(id=1572103477533528065, number=8, status=2, customerId=1, orderTime=2022-09-20T16:00:51, pay_method=null, total=15.40, remark=, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1572103479525822466, productName=Latte, image=null, orderId=8, productId=5, size=small, extra=, quantity=2, amount=2.80, createTime=2022-09-20T16:00:52, updateTime=2022-09-20T16:00:52), OrderDetail(id=1572103481543282690, productName=Cappuccino, image=null, orderId=8, productId=2, size=large, extra=, quantity=1, amount=3.50, createTime=2022-09-20T16:00:53, updateTime=2022-09-20T16:00:53), OrderDetail(id=1572103483573325825, productName=Caramel Slice, image=null, orderId=8, productId=14, size=large, extra=, quantity=1, amount=3.80, createTime=2022-09-20T16:00:53, updateTime=2022-09-20T16:00:53), OrderDetail(id=1572103485603368961, productName=Espresso, image=null, orderId=8, productId=3, size=small, extra=, quantity=1, amount=2.50, createTime=2022-09-20T16:00:54, updateTime=2022-09-20T16:00:54)], createTime=2022-09-20T16:00:52, updateTime=2022-09-20T16:00:52), Orders(id=1572083641994678273, number=7, status=2, customerId=1, orderTime=2022-09-20T14:42:02, pay_method=null, total=9.40, remark=assadvsv, phone=0448111111, customerName=xiaoyu fan2, orderDetails=[OrderDetail(id=1572083643966001154, productName=Ginger Tea, image=null, orderId=7, productId=9, size=small, extra=, quantity=1, amount=2.80, createTime=2022-09-20T14:42:03, updateTime=2022-09-20T14:42:03), OrderDetail(id=1572083646046375937, productName=Donut Cookie, image=null, orderId=7, productId=13, size=small, extra=, quantity=1, amount=2.80, createTime=2022-09-20T14:42:04, updateTime=2022-09-20T14:42:04), OrderDetail(id=1572083647988338689, productName=Latte, image=null, orderId=7, productId=5, size=small, extra=soy milk, quantity=1, amount=3.80, createTime=2022-09-20T14:42:04, updateTime=2022-09-20T14:42:04)], createTime=2022-09-20T14:42:03, updateTime=2022-09-20T14:42:03)]";

        Assertions.assertEquals(expected1, orders1.toString());
        Assertions.assertEquals(expected2, orders2.toString());
        Assertions.assertTrue(empty.isEmpty());
    }

}
