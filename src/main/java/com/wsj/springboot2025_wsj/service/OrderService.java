package com.wsj.springboot2025_wsj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService extends IService<Order> {
//业务层是被控制层调用的

    Result addOrderService(Order order);

    Result deleteOrderByIdService(Integer id);

    Result findOrderByIdNameService(Integer id,String name);

    Result findAllOrdersService();

    Result updateOrderByIdService(Integer id, String orderName);

    Result findOrdersByNameService(String orderName);

    Result findOrdersByIdService(Integer id);

    Result updateOrder(Order order);













}
