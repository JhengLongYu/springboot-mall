package com.leoyu.springbootmall.service;

import com.leoyu.springbootmall.dto.CreateOrderRequest;
import com.leoyu.springbootmall.dto.OrderQueryParams;
import com.leoyu.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

}
