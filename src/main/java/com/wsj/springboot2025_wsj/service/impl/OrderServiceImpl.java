package com.wsj.springboot2025_wsj.service.impl;

import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.mappers.OrderMapper;
import com.wsj.springboot2025_wsj.pojo.Order;
import com.wsj.springboot2025_wsj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;


    @Override
    public Result addOrderService(Order order) {

        if(order==null){
            return new Result(201,"提交的数据不能为空",null);

        }
        int result = orderMapper.addOrder(order);
        if(result !=1){
            return new Result(202,"添加失败",null);

        }
        return new Result(200,"添加成功",null);
    }

    @Override
    public Result deleteOrderByIdService(Integer id) {

        if(id==null){
            return new Result(201,"没有需要删除的数据",null);
        }

        int result = orderMapper.deleteOrderById(id);
        if(result !=1){
            return new Result(202,"删除失败，请稍后再试",null);
        }
        return new Result(200,"删除成功",null);
    }

    @Override
    public Result findOrderByIdNameService(Integer id,String orderName) {

        if(id==null){
            return new Result(201,"id不允许为空",null);
        }
        if(orderName==null){
            return new Result(202,"订单名称不允许为空",null);
        }

        Order order = orderMapper.findOrderByIdName(id, orderName);
        if(order != null){
            List<Order> list = new ArrayList<>();
            list.add(order);
            return new Result(200,"查询成功",list);
        }else {
            return new Result(201,"没有查询到任何数据",null);
        }
    }

    @Override
    public Result findAllOrdersService() {
        List<Order> list = orderMapper.selectList(null);
        if(list != null && !list.isEmpty()){
            return new Result(200,"查询成功",list);
        }else {
            return new Result(201,"没有查询到任何数据",null);
        }
    }

    @Override
    public Result updateOrderByIdService(Integer id, String orderName) {
        if(id == null){
            return new Result(201,"id不允许为空",null);
        }
        if(orderName == null || orderName.isEmpty()){
            return new Result(202,"订单名称不允许为空",null);
        }

        int i = orderMapper.updateOrderById(id, orderName);
        if(i != 1){
            return new Result(203,"修改失败",null);
        }
        return new Result(200,"修改成功",orderName);
    }

    @Override
    public Result findOrdersByNameService(String orderName) {
        if(orderName == null || orderName.isEmpty()){
            // 如果orderName为空，则查询所有订单
            return new Result(201,"订单名称不能为空",null);
        }
        List<Order> orderByLike = orderMapper.findOrderByLike(orderName);
        if (orderByLike != null && !orderByLike.isEmpty()) {
            return new Result(200,"查询成功",orderByLike);
        }else {
            return new Result(203,"查询失败,未找到数据",null);
        }
    }
}
