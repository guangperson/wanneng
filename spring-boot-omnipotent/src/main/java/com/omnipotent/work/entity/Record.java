package com.omnipotent.work.entity;

import lombok.Data;

@Data
public class Record {
    private Integer rid;

    /**
    * 资源主键
    */
    private Integer resid;

    /**
    * 标识（1/2）下载/浏览
    */
    private String flag;
}