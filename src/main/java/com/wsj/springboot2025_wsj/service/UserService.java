package com.wsj.springboot2025_wsj.service;

import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.pojo.User;

import java.util.List;

public interface UserService {

    Result addUser(User user);

    Result selectUserById(Integer id);

    Result updateUser(User user);

    Result findAllUser();

    Result deleteUserById(Integer id);

    Result findUsers(List<Integer> ids);


}


