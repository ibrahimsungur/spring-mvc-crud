package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
private StudentDao studentDao;	
	
	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return studentDao.listStudent();
	}

	@Override
	public void addStudent(Student student) {
	studentDao.addStudent(student);
		
	}

	@Override
	public void deleteStudent(long id) {
	studentDao.deleteStudent(id);
		
	}

	@Override
	public void updateStudent(Student student) {
	studentDao.updateStudent(student);
		
	}

	@Override
	public Student getById(long id) {
	
		return studentDao.getById(id);
	}

}
