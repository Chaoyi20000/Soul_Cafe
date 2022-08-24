package com.it.soul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.soul.mapper.ProductMapper;
import com.it.soul.model.Product;
import com.it.soul.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
