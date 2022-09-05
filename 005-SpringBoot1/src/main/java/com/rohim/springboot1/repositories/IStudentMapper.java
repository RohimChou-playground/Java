package com.rohim.springboot1.repositories;

import com.rohim.springboot1.models.Student;

public interface IStudentMapper {
	public Student findById(int id);
}
