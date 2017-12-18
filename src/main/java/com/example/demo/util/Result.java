package com.example.demo.util;

/**
 * Created by 10108 on 2017/12/17.
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result simpleRightResult(Object object){
        return new Result(1,"success",object);
    }
    public static Result simpleBadResult(int code,String message){
        return new Result(code,message);
    }

    public static Result simpleBadResult(String msg){
        return new Result(0,msg);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
