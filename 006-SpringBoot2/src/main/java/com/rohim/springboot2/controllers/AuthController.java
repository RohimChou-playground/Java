package com.rohim.springboot2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rohim.springboot2.models.User;

@Controller
@RequestMapping(path="auth")
public class AuthController {

	@RequestMapping(path="login", method=RequestMethod.GET)
	public String index() {
		return "login.html";
	}
}
