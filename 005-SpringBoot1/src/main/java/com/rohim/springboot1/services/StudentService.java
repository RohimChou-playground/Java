package com.rohim.springboot1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohim.springboot1.models.Student;
import com.rohim.springboot1.repositories.IStudentMapper;

@Service
public class StudentService {
	
	@Autowired
	public IStudentMapper studentRepo;
	
	public Student findById(int id) {
		return this.studentRepo.findById(id);
	}
}
