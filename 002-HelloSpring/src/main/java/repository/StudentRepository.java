package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Student;

@Repository
public class StudentRepository implements CrudRepository{

	public List findAll() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "John", "john@mail.com"));
		return students;
	}

}
