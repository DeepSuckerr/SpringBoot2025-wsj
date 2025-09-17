package com.wsj.springboot2025_wsj.pojo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@Data
@Component
public class Student implements Serializable {

    @Value("${stu.name}")
    private String name;
    @Value("${stu.id}")
    private Integer id;
    @Value("${stu.pwd}")
    private String pwd;




}
