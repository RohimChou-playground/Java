package com.rohim.springboot1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
	
	private Logger logger1 = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(path = "t1", method = RequestMethod.GET)
	@ResponseBody
	public Object t1() {
		this.logger1.error("Hello World From logger1");
		this.logger1.debug("Some Debug Info");
		return "Hello World";
	}
}