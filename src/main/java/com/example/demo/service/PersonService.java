package com.example.demo.service;

import com.example.demo.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 10108 on 2017/12/17.
 */
public interface PersonService extends JpaRepository<Person,Integer> {
    public List<Person> queryByPsw(String psw);

    public Person queryByPswAndName(String psw,String name);
}
