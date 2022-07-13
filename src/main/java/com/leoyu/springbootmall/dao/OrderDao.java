package com.leoyu.springbootmall.dao;

import com.leoyu.springbootmall.dto.OrderQueryParams;
import com.leoyu.springbootmall.model.Order;
import com.leoyu.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    Integer countOrder(OrderQueryParams orderQueryParams);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);


}
