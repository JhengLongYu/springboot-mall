package com.leoyu.springbootmall.service;

import com.leoyu.springbootmall.dto.ProductRequest;
import com.leoyu.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
