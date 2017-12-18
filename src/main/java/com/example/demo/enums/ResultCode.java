package com.example.demo.enums;

/**
 * Created by 10108 on 2017/12/17.
 */
public enum  ResultCode {
    SUCCESS(1,"success"),
    FAIL(0,"fail"),
    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
