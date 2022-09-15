package com.omnipotent.work.entity;

import lombok.Data;

@Data
public class Money {
    /**
    * 用户下载点数主键
    */
    private Integer mid;

    /**
    * 用户主键
    */
    private Integer uid;

    /**
    * 用户点数
    */
    private Integer number;
}