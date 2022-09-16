package com.omnipotent.work.common;

public enum Contants {

    LONGIN_OK(1, "登录成功!"),
    LONGIN_ERROR(-1,"登录失败，用户不存在或密码错误!"),
    REG_OK(1001,"注册成功"),
    REG_ERROR(-1,"注册失败");
    private final Integer code;

    private final String msg;

    Contants(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
