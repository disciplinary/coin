package com.coin.controller;

import com.coin.entity.User;
import com.coin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Author shiyawei
 * @Date 2021/5/5
 * @Version V1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/queryAllUsers")
    public List<User> queryAllUsers(){
        return userService.queryAllUsers();
    }

    @GetMapping(value = "/queryUserById")
    public User queryUserById(@RequestParam("id") Integer id) {
        return userService.queryUserById(id);
    }


    @GetMapping(value = "/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "添加用戶成功";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "修改用戶成功";
    }

    @GetMapping(value = "/deleteUserById")
    public String deleteUserById(@RequestParam("id") Integer id){
        userService.deleteUserById(id);
        return "刪除用戶成功";
    }
}