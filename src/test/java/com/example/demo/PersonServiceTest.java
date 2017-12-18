package com.example.demo;

import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 10108 on 2017/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    @Autowired
    PersonService personService;
    @Test
    public void findById(){
        Person person = personService.findOne(1);
        Assert.assertEquals("lijinxuan2",person.getName());
    }
}
