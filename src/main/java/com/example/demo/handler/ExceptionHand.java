package com.example.demo.handler;

import com.example.demo.exception.MyException;
import com.example.demo.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 10108 on 2017/12/17.
 */
@ControllerAdvice
public class ExceptionHand {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if(e instanceof MyException){
            MyException myException = (MyException)e;
            return Result.simpleBadResult(myException.getMessage());
        }
        return Result.simpleBadResult("异常信息"+e.getMessage());
    }
}
