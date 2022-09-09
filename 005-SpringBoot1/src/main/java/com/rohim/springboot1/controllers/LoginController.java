package com.rohim.springboot1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rohim.springboot1.models.User;

@Controller
@RequestMapping(path="login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("login");
		mw.addObject("user", new User());
		
		return mw;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView postLogin(@ModelAttribute User user) {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("login-success.html");
		mw.addObject("user", user);
		
		return mw;
	}
}
