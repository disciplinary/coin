package com.coin.service;

import com.coin.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author shiyawei
 * @Date 2021/5/5
 * @Version V1.0
 **/
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAllUsers();

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User queryUserById(int userId);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUserById(int userId);
}