package com.rohim.springboot2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView index() {
		logger.debug("Home Page Hit");
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("index.html");
		
		return mw;
	}
}
