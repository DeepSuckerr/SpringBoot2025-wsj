package com.wsj.springboot2025_wsj.controller;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.pojo.Order;
import com.wsj.springboot2025_wsj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderController{

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody Order order){
        Result result = orderService.addOrderService(order);
        return result;

    }

    @GetMapping("/deleteOrderById/{id}")
    public Result deleteOrderById(@PathVariable("id") Integer id){
        Result result = orderService.deleteOrderByIdService(id);
        return result;
    }

    @GetMapping("/findOrderByIdName")
    public Result findOrderByIdName(Integer id,String orderName){
        Result result = orderService.findOrderByIdNameService(id,orderName);
        return result;
    }

    @GetMapping("/findAllOrders")
    @CrossOrigin
    public Result findAllOrders(){
        Result result = orderService.findAllOrdersService();
        return result;
    }

    @PostMapping("/updateOrderById")
    public Result updateOrderById(Integer id, String orderName){
        Result result = orderService.updateOrderByIdService(id, orderName);
        return result;
    }

    @GetMapping("/findOrdersByName")
    public Result findOrdersByName(String orderName){
        Result result = orderService.findOrdersByNameService(orderName);
        return result;
    }

    @GetMapping("/findOrderById/{id}")
    public Result findAllOrdersByUserId(@PathVariable("id") Integer id){
        Result result = orderService.findOrdersByIdService(id);
        return result;
    }

    @PostMapping("/updateOrder")
    public Result updateOrder(@RequestBody Order order){
        Result result = orderService.updateOrder(order);
        return result;
    }



}