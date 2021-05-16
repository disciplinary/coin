package com.coin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Description: TODO
 * @Author shiyawei
 * @Date 2021/5/5
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
@TableName("t_user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(exist = false)
    private String ignoreColumn = "ignoreColumn";

    @TableField(exist = false)
    private Integer count;
}