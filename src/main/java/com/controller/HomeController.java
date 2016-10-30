package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.model.Student;
import com.service.StudentService;


@Controller
public class HomeController {

@Autowired
private StudentService studentService;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Student>>listStudent(){
    List<Student>students=studentService.listStudent();	
    
   if(students.isEmpty()){
   return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT)	;
     }
		return new ResponseEntity<List<Student>>(HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> goingStudent(@PathVariable("id") long id) {

		Student student =  studentService.getById(id);

		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder componentsBuilder) {

		 studentService.addStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(componentsBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {

		Student student =  studentService.getById(id);
		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		 studentService.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {

		Student updatedStudent = studentService.getById(id);

		if (updatedStudent == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		updatedStudent.setAdi(student.getAdi());
		updatedStudent.setSoyadi(student.getSoyadi());

		studentService.updateStudent(updatedStudent);
	
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	}

}
