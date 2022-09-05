package com.rohim.springboot1.services;

import java.util.List;

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

	public List<Student> findAll() {
		return this.studentRepo.findAll();
	}

	public int insert(Student student) {
		return this.studentRepo.insert(student);
	}

	public int deleteById(int id) {
		return this.studentRepo.deleteById(id);
	}

	public int updateEnglish(int id, Integer english) {
		return this.studentRepo.updateEnglish(id, english);
	}
}
