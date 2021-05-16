package com.coin.repository.impl;

import com.coin.entity.User;
import com.coin.mapper.UserMapper;
import com.coin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserRepositoryImpl
 * @Author shiyawei
 * @Date 2021/5/16
 * @Version V1.0
 **/
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User entity) {
        return 0;
    }
}
