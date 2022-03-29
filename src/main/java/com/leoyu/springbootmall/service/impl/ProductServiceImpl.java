package com.leoyu.springbootmall.service.impl;

import com.leoyu.springbootmall.dao.ProductDao;
import com.leoyu.springbootmall.model.Product;
import com.leoyu.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }


}
