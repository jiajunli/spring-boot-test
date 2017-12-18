package com.example.demo.service;

import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 10108 on 2017/12/17.
 */
@Service
public class PersonServiceImpl {
    @Autowired
    PersonService personService;

    @Transactional
    public void add(){
        try{
            Person person1= new Person();
            person1.setName("lijiajun");
            person1.setPsw("123455");
            personService.save(person1);
            System.out.println(10/0);

            Person person2= new Person();
            person2.setName("lijiajun2");
            person2.setPsw("1234552");
            personService.save(person2);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
