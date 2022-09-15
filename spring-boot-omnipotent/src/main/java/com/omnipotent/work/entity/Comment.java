package com.omnipotent.work.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Comment {
    /**
    * 评论表主键
    */
    private Integer cid;

    private String comments;

    /**
    * 评论时间
    */
    private Date comdate;

    /**
    * 用户主键
    */
    private Integer uid;

    /**
    * 资源主键
    */
    private Integer resid;
}