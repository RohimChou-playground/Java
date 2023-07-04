package com.rohim.web.controllers;

import com.rohim.web.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	public static List<Student> students = new ArrayList<Student>();

	static {
		Student student1 = new Student(1, "Rohim");
		Student student2 = new Student(2, "John");
		Student student3 = new Student(3, "Amy");
		students.add(student1);
		students.add(student2);
		students.add(student3);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getById(@PathVariable String id) {
		Student student = students.stream()
				.filter(stu -> stu.getId() == Integer.parseInt(id)).findFirst().get();
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addNew(@RequestBody Student newStudent) {
		students.add(newStudent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		Student student = students.stream()
				.filter(stu -> stu.getId() == Integer.parseInt(id)).findFirst().get();
		students.remove(student);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
