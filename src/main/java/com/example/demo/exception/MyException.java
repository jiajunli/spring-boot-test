package com.example.demo.exception;

/**
 * Created by 10108 on 2017/12/17.
 */
public class MyException extends  RuntimeException {
    private int code;
    public MyException(int code,String message){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
