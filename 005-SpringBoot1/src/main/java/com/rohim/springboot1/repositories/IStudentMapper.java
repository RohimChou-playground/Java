package com.rohim.springboot1.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rohim.springboot1.models.Student;

public interface IStudentMapper {
	public Student findById(int id);

	public List<Student> findAll();

	public int insert(Student student);

	public int deleteById(int id);

	public int updateEnglish(@Param("id") int id, @Param("english") Integer english);
}
