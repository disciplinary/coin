package com.coin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coin.entity.User;
import com.coin.mapper.UserMapper;
import com.coin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author shiyawei
 * @Date 2021/5/5
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public User queryUserById(int userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        Wrapper<User> updateWrapper= new QueryWrapper<User>()
                .lambda().eq(User::getId, 2);
        userMapper.update(user,updateWrapper);
    }

    @Override
    public void deleteUserById(int userId) {
        userMapper.deleteById(userId);
    }
}
