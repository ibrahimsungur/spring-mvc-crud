package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {

	public List<Student>listStudent(); 
	public void addStudent(Student student);
	public void deleteStudent(long id);
	public void updateStudent(Student student);
	public Student getById(long id);
}
