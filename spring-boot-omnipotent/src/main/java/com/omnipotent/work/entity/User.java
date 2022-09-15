package com.omnipotent.work.entity;

import lombok.Data;

@Data
public class User {
    /**
    * 用户id
    */
    private Integer uid;

    /**
    * 用户账号
    */
    private String username;

    /**
    * 用户密码
    */
    private String password;

    private String nickname;

    /**
    * 用户真名
    */
    private String name;

    /**
    * 电话
    */
    private String phone;

    /**
    * 下载记录（记录id）
    */
    private Integer rid;
}