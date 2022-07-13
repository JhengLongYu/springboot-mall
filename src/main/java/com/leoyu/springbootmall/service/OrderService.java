package com.leoyu.springbootmall.service;

import com.leoyu.springbootmall.dto.CreateOrderRequest;
import com.leoyu.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
