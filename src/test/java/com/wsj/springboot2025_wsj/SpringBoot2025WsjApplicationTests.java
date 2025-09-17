package com.wsj.springboot2025_wsj;

import com.wsj.springboot2025_wsj.mappers.OrderMapper;
import com.wsj.springboot2025_wsj.pojo.Order;
import com.wsj.springboot2025_wsj.pojo.Student;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com/wsj/springboot2025_wsj/mappers")
class SpringBoot2025WsjApplicationTests {


    @Autowired
    Order order;
    @Autowired
    Student student;

    @Autowired
    OrderMapper orderMapper;


    @Test
   public void Test01() {
        System.out.println(order);
    }
    @Test
    public void Test02() {
        System.out.println(student);
    }
    @Test
    public void Test03() {
        Order order1 = new Order();
        order1.setOrderCode("9999");
        order1.setOrderName("牛肉面");

    }

}
