package com.rohim.springboot1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
	
	public TestController() {
		System.out.println("TestController created");
	}

	private Logger logger1 = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(path = "t1", method = RequestMethod.GET)
	@ResponseBody
	public Object t1() {
		this.logger1.error("Hello World From logger1");
		this.logger1.debug("Some Debug Info");
		return "Hello World";
	}
	
	Integer counter = 0;
	@RequestMapping(path = "t2", method = RequestMethod.GET)
	@ResponseBody
	public Object t2() {
		this.logger1.debug("1 Hello World 2 From logger1");
		
		// key is case sensitive
		// everytime controller is called will be reset
		MDC.put("firstName", "John" + ++counter);
		
		this.logger1.debug("2 Hello World 2 From logger1");
		return "Hello World 2";
	}
}