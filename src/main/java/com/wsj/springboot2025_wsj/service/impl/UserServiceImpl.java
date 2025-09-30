package com.wsj.springboot2025_wsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.mappers.UserMapper;
import com.wsj.springboot2025_wsj.pojo.User;
import com.wsj.springboot2025_wsj.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Wrapper;
import java.util.List;


@Service
@CrossOrigin
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public Result addUser(User user) {

        if(user==null){
            return new Result(201,"新增数据不能为空",null);

        }
        if ("".equals(user.getUserName()) || null == user.getUserName()) {
            return new Result(202,"用户名不能为空",null);

        }
        if ("".equals(user.getPassword()) || null == user.getPassword()) {
            return new Result(203,"密码不能为空",null);

        }
        // 只检查用户名是否已存在
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("user_name", user.getUserName());
        User user1 = userMapper.selectOne(wrapper);
        if(user1 != null){
            return new Result(205,"该用户名已存在",null);
        }

        int row = userMapper.insert(user);
        if(row>0){
            return new Result(200,"操作成功",row);
        }else{
            return new Result(204,"新增失败",null);
        }

    }

    @Override
    public Result selectUserById(Integer id) {

        if(id==null){
            return new Result(201,"没有指定查询的数据",null);
        }
        if ("".equals(id) || null == id) {
            return new Result(202,"id不能为空",null);
        }

//        User user = userMapper.selectById(id);
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("id", id);
        User user = userMapper.selectOne(wrapper);

        if(user==null){
            return new Result(203,"该用户不存在",null);
        }else{
            return new Result(200,"查询成功",user);
        }
    }

    @Override
    public Result updateUser(User user) {

//        int row = userMapper.updateById(user);
        int row = userMapper.update(user, new QueryWrapper<User>().eq("id", user.getId()));


        if(row != 1){
            return new Result(201,"修改失败",null);
        }else {
            return new Result(200,"修改成功",null);
        }
    }

    @Override
    @CrossOrigin
    public Result findAllUser() {
        List<User> users = userMapper.selectList(null);
        if(users!=null&& !users.isEmpty()){
            return new Result(200,"查询成功",users);
        }else {
            return new Result(201,"查询失败",null);
        }
    }

    @Override
    public Result deleteUserById(Integer id) {
        if(id == null){
            return new Result(201,"id值不能为空",null);
        }
        int row = userMapper.deleteById(id);
        if(row !=1){
            return new Result(202,"删除失败",null);
        }else {
            return new Result(201,"删除成功",id);
        }
    }

    @Override
    @CrossOrigin
    public Result findUsers(List<Integer> ids) {
        List<User> users = userMapper.findUsers(ids);
        return new Result(200,"查询成功",users);
    }

    @Override
    public Result doLogin(User user) {
        if (user == null){
            return new Result(201,"登录信息不能为空",null);

        }if ("".equals(user.getUserName()) || null == user.getUserName()) {
            return new Result(202,"登录名不能为空",null);

        }if ("".equals(user.getPassword()) || null == user.getPassword()) {
            return new Result(203,"登录密码不能为空",null);
        }

        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("user_name", user.getUserName()).eq("password", user.getPassword());
        User user1 = userMapper.selectOne(wrapper);

        if (user1 == null){
            return new Result(204,"请检查登录信息",null);
        }

        if (user1.getUserName().equals(user.getUserName()) && user1.getPassword().equals(user.getPassword())) {
            return new Result(200,"登录成功",null);
        }
        return new Result(205,"请检查账号和密码",null);
    }


}
