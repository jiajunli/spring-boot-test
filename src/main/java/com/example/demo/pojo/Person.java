package com.example.demo.pojo;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by 10108 on 2017/12/17.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Length(min = 10,message = "长度最小为10位")
    private String psw;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
