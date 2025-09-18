package com.wsj.springboot2025_wsj.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsj.springboot2025_wsj.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> findUsers(List<Integer> ids);
}
