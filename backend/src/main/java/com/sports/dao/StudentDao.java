package com.sports.dao;

import java.util.List;

import com.sports.model.Student;

public interface StudentDao {
	List<Student> getAllStudents();
	Student addStudent(Student student);
	Student getStudentById(int id);
	void deleteStudent(int id);


}
