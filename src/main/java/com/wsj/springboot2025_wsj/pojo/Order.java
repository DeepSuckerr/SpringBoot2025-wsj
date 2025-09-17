package com.wsj.springboot2025_wsj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
@ConfigurationProperties(prefix = "order")
@Accessors(chain = true)
public class Order implements Serializable {

    private Integer id;
    private String orderCode;
    private String orderName;
    private Double price;
    private Integer isPay;
    private String address;



}
