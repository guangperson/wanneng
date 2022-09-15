package com.omnipotent.work.entity;

import lombok.Data;

@Data
public class Resource {
    /**
    * 资源id主键
    */
    private Integer resid;

    /**
    * 资源名称
    */
    private String resname;

    /**
    * 简介
    */
    private String brief;

    /**
    * 下载链接
    */
    private String reslink;

    /**
    * 下载数量
    */
    private Integer nums;
}