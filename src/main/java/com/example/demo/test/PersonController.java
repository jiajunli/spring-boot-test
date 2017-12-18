package com.example.demo.test;

import com.example.demo.exception.MyException;
import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 10108 on 2017/12/17.
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonServiceImpl personService2;

    @GetMapping("/list")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/add")
    public Person add(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return personService.save(person);
    }
    @GetMapping("/test")
    public void test(){
        throw new MyException(0,"测试错误");
    }

    @GetMapping("/find/{id}")
    public Result<Person> queryById(@PathVariable("id") int id) {
        return Result.simpleRightResult(personService.findOne(id));
    }



    @GetMapping("/update/{id}")
    public void updateById(@PathVariable("id") int id) {
        Person person = new Person();
        person.setName("jinxuanli234");
        person.setPsw("42232323");
        person.setId(id);
        personService.save(person);
    }

    @GetMapping("delete/{id}")
    public void deleteById(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @GetMapping("/queryByPsw")
    public List<Person> queryByPsw(@RequestParam("psw") String psw) {
        return personService.queryByPsw(psw);
    }

    @GetMapping("/login")
    public Person login(@RequestParam("psw") String psw, @RequestParam("name") String name) {
        return personService.queryByPswAndName(psw, name);
    }

    @GetMapping("/add2")
    public String add2() {
        personService2.add();
        return "success";
    }

}
