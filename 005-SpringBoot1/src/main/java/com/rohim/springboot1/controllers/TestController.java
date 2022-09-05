package com.rohim.springboot1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohim.springboot1.models.Student;
import com.rohim.springboot1.services.StudentService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	StudentService studentService;
	
    /**
     * Find Student by Id
     */
	@RequestMapping(path = "t1/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object findById(@PathVariable("id") int id) {
		Student student = this.studentService.findById(id);
		return "StudentId: " + id + ", Name: " + student.getName();
	}
	
    /**
     * Find All Students
     */
	@RequestMapping(path = "t1/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> findAll() {
		List<Student> students = this.studentService.findAll();
		return students;
	}
	
    /**
     * Insert test Student
     * e.g. t1/insert?name=Steven&math=55
     */
	@RequestMapping(path = "t1/insert", method = RequestMethod.GET)
	@ResponseBody
	public Object insert(@RequestParam("name") String name, @RequestParam("math") Integer math) {
		Student student = new Student();
		student.setName(name);
		student.setMath(math);
		return this.studentService.insert(student) + " rows inserted";
	}
	
    /**
     * Delete Student
     * e.g. t1/delete/5
     */
	@RequestMapping(path = "t1/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable("id") int id) {
		return this.studentService.deleteById(id) + " rows deleted";
	}
	
    /**
     * Update Student
     * e.g. t1/update/15?english=69
     */
	@RequestMapping(path = "t1/update/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object update(@PathVariable("id") int id, @RequestParam("english") Integer english) {
		return this.studentService.updateEnglish(id, english);
	}
}