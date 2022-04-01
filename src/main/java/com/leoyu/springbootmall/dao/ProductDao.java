package com.leoyu.springbootmall.dao;

import com.leoyu.springbootmall.dto.ProductQueryParams;
import com.leoyu.springbootmall.dto.ProductRequest;
import com.leoyu.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
