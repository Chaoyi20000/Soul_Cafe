package com.it.soul.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.soul.model.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
