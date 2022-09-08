package com.rohim.springboot1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rohim.springboot1.models.Student;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping(path = "t1", method = RequestMethod.GET)
	@ResponseBody
	public Object t1() {
		return "Hello World";
	}
	
	@RequestMapping(path = "t2", method = RequestMethod.GET)
	public String t2() {
		// return "index"; << this would work too
		return "index.html";
	}
	
	@RequestMapping(path = "t3", method = RequestMethod.GET)
	public ModelAndView t3() {
		List<Student> students = new ArrayList<Student>();
		Student st1 = new Student();
		st1.setId(1);
		st1.setName("John");
		students.add(st1);
		
		Student st2 = new Student();
		st2.setId(2);
		st2.setName("Amy");
		students.add(st2);
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("students");
		mw.addObject("students", students);
		
		return mw;
	}
}
