package com.wsj.springboot2025_wsj.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("tb_user")
public class User implements Serializable {


    private Integer id;
    private String userName;
    private String password;
    private String age;
    private String tel;
    private String idCard;

}
