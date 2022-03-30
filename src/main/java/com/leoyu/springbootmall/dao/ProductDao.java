package com.leoyu.springbootmall.dao;

import com.leoyu.springbootmall.dto.ProductRequest;
import com.leoyu.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
