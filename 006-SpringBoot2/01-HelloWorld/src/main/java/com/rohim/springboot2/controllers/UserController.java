package com.rohim.springboot2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohim.springboot2.models.User;
import com.rohim.springboot2.services.UserService;

@Controller
@RequestMapping(path="/data/users")
public class UserController {
	
	@Autowired
	UserService userSerivce;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<User> index() {
		List<User> users = this.userSerivce.findAll();;
		return users;
	}
}
