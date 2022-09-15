package com.omnipotent.work.common;

import java.util.Objects;

public class Results {
    /**
     * 消息
     */
    private String msg;
    /**
     * 总数
     */
    private long count;
    /**
     * 数据
     */
    private Object data;
    /**
     *标志
     */
    private int code;


    public  Results setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Results setCount(Long count) {
        this.count = count;
        return this;
    }

    public Results setData(Object data) {
        this.data = data;
        return this;
    }

    public Results setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Long getCount() {
        return count;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }
}
