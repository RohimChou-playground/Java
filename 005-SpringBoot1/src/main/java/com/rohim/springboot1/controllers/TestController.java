package com.rohim.springboot1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohim.springboot1.models.Student;
import com.rohim.springboot1.services.StudentService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(path = "t1/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object t1(@PathVariable("id") int id) {
		Student student = this.studentService.findById(id);
		return "StudentId: " + id + ", Name: " + student.getName();
	}
}