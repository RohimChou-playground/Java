package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Student;
import repository.StudentRepository;

@Service
public class StudentService implements CrudService {

	private StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public List list() {
		List<Student> students = this.studentRepo.findAll();
		return students;
	}

	public Object create(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Object t, int id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
