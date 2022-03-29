package com.leoyu.springbootmall.dao;

import com.leoyu.springbootmall.model.Product;

public interface ProductDao {

    public Product getProductById(Integer productId);
}
