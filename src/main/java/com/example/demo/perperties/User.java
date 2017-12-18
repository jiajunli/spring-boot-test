package com.example.demo.perperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 10108 on 2017/12/17.
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String username;

    public String getPsw() {
        return psw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    private String psw;


}
