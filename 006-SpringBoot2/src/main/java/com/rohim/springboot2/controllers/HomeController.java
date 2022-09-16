package com.rohim.springboot2.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("index.html");
		
		return mw;
	}
	
	@RequestMapping(path="/mylogin", method=RequestMethod.GET)
	public ModelAndView mylogin() {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("mylogin.html");
		
		return mw;
	}
}
