package com.example.demo.test;

import com.example.demo.perperties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

//	@Value("${user.name}")
//	private String name;
	@Autowired
	private User user;


	@RequestMapping("/hello5")
	public String test(Model model){
		model.addAttribute("name", user.getUsername()+"| "+ user.getPsw());
		return "hello";
	}

}
