package com.wsj.springboot2025_wsj.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsj.springboot2025_wsj.pojo.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    //添加订单数据
    int addOrder(Order order);
    //增删改返回表数据的受影响行数
    int deleteOrderById(Integer id);

    Order findOrderByIdName(Integer id ,String orderName);

    int  updateOrderById(Integer id, String orderName);

    List<Order> findOrderByLike(String orderName);

    Order selectByIds(Integer id);

    int updateOrder(Order order);
}
