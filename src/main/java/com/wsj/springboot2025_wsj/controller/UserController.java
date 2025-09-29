package com.wsj.springboot2025_wsj.controller;

import com.wsj.springboot2025_wsj.commons.Result;
import com.wsj.springboot2025_wsj.pojo.User;
import com.wsj.springboot2025_wsj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    @CrossOrigin
    public Result addUser(@RequestBody User user){
        Result result = userService.addUser(user);
        return result;
    }

    @GetMapping("/selectUserById/{id}")
    public Result selectUserById(@PathVariable("id") Integer id){
        Result result = userService.selectUserById(id);
        return result;
    }

    @GetMapping("/doUpdate")
    public  Result updateUser(@RequestBody User user){
        Result result = userService.updateUser(user);
        return result;
    }


    @GetMapping("/findAlluser")
    @CrossOrigin
    public Result findAllUser(){
        Result result = userService.findAllUser();
        return result;
    }

    @GetMapping("/deleteUserById")
    public Result deleteUserById(Integer id){
        Result result = userService.deleteUserById(id);
        return result;
    }

    @GetMapping("/findUsers/{id1}/{id2}/{id3}")
    public Result findUsers(@PathVariable("id1") Integer id1,
                            @PathVariable("id2") Integer id2,
                            @PathVariable("id3") Integer id3){
        List<Integer> ids = new ArrayList<>();
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);
        Result result = userService.findUsers(ids);
        return result;
    }

    @PostMapping("/doLogin")
    @CrossOrigin
    public Result doLogin(@RequestBody User user){
        Result result = userService.doLogin(user);
        return result;
    }


 }
