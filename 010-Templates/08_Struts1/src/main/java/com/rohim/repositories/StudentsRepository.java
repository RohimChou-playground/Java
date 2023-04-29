package com.rohim.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsRepository {
    public static List<String> students;

    public StudentsRepository() {
        if (students == null) {
            students = new ArrayList<String>(Arrays.asList("Rukis", "Eason"));
        }
    }

    public List<String> getStudents() {
        return students;
    }

    public void createStudent(String newStudentName) {
        students.add(newStudentName);
    }
}
