package com.it.soul.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.soul.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
