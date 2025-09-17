package com.wsj.springboot2025_wsj.service;

import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.pojo.Order;

public interface OrderService {
//业务层是被控制层调用的

    Result addOrderService(Order order);

    Result deleteOrderByIdService(Integer id);

    Result findOrderByIdNameService(Integer id,String name);

    Result findAllOrdersService();

    Result updateOrderByIdService(Integer id, String orderName);










}
