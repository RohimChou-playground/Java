package com.foo.myspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping(path = "t1", method = RequestMethod.GET)
	@ResponseBody
	public Object t1() {
		return "Hello World";
	}
}