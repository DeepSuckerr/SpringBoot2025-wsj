package com.wsj.springboot2025_wsj.mappers;

import com.wsj.springboot2025_wsj.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderMapper {

    //添加订单数据
    int addOrder(Order order);
    //增删改返回表数据的受影响行数
    int deleteOrderById(Integer id);

    Order findOrderByIdName(Integer id ,String orderName);

    List<Order> findAllOrders();

    int  updateOrderById(Integer id, String orderName);



}
