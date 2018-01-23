package com.sports.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sports.dao.StudentDao;
	import com.sports.model.Student;


	

	@RestController
	public class StudentController{
		@Autowired
	private StudentDao studentDao;
		@RequestMapping(value="/getallstudents",method=RequestMethod.GET)
		public  List<Student> getAllStudents(){
			List<Student> students=studentDao.getAllStudents();
			return students;
		}
		

		//Input - student object in JSON format 
		//JSON to Java object @RequestBody  [Http Request Body contains data in JSON fmt]
		//Output - student object in JSON format
		@RequestMapping(value="/addstudent",method=RequestMethod.POST)
		public  Student addStudent(@RequestBody Student student){
			student=studentDao.addStudent(student);
			return student;
		
		}
	

	       @RequestMapping(value="/getstudent/{id}",method=RequestMethod.GET)
		//http://localhost:8080/...../getstudent/1
		// T is Type of data
		//? - Any type of data
		public Student getStudentById(@PathVariable int id){
			Student student=studentDao.getStudentById(id);
			return student;
		}
	       

	       @RequestMapping(value="/deletestudent/{id}",method=RequestMethod.DELETE)
		public   List<Student> deleteStudent(@PathVariable int id){
			studentDao.deleteStudent(id);
			List<Student> students=studentDao.getAllStudents();
			return students;
		
		
	}
	}
	
	

	
	


