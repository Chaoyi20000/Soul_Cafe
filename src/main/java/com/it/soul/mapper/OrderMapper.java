package com.it.soul.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.soul.model.Cart;
import com.it.soul.model.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
