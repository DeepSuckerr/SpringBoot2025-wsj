package com.wsj.springboot2025_wsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.mappers.OrderMapper;
import com.wsj.springboot2025_wsj.pojo.Order;
import com.wsj.springboot2025_wsj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private Order order;


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

    @Override
    public Result findOrdersByIdService(Integer id) {
        Order order = orderMapper.selectByIds(id);
        if (id==null) {
            return new Result(201,"没有指定可以返回的数据",null);
        }else {
            return new Result(200,"查询成功",order);
        }
    }

    @Override
    public Result updateOrder(Order order) {
        if(order.getId()==null){
            return new Result(201,"没有指定修改的数据",null);
        }
        if(order.getOrderName() == null || order.getOrderName().isEmpty()){
            return new Result(202,"订单编号不能为空",null);
        }
        int result = orderMapper.updateOrder(order);
        if(result != 1){
            return new Result(203,"修改失败",null);
        }else {
            return new Result(200,"修改成功",null);
        }
    }

    @Override
    public boolean saveBatch(Collection<Order> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Order> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Order> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Order entity) {
        return false;
    }

    @Override
    public Order getOne(Wrapper<Order> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Optional<Order> getOneOpt(Wrapper<Order> queryWrapper, boolean throwEx) {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Order> queryWrapper) {
        return Map.of();
    }

    @Override
    public <V> V getObj(Wrapper<Order> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Order> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Order> getEntityClass() {
        return null;
    }
}
