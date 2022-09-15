package com.omnipotent.work.entity;

import lombok.Data;

@Data
public class Like {
    /**
    * 点赞主键
    */
    private Integer gid;

    /**
    * 评论主键
    */
    private Integer cid;

    /**
    * 资源主键
    */
    private Integer resid;

    /**
    * 点赞数
    */
    private Integer number;
}