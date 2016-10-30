package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

private static final Logger log = LoggerFactory.getLogger(StudentDaoImpl.class);

@Autowired
private SessionFactory sessionFactory;
Session session=sessionFactory.getCurrentSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent() {
		

List<Student>list=session.createQuery("From Student").list();
for(Student student :list){
log.info("Student Lists :"+student);	
}
		return list;
	}

	@Override
	public void addStudent(Student student) {
	session.save(student);
	log.info("Student Add :"+student);
		
	}

	@Override
	public void deleteStudent(long id) {
	 Student student=new Student();
	 student.getId();
	 session.delete(student);
	 log.info("Student deleted:"+student);
		
	}

	@Override
	public void updateStudent(Student student) {
	session.update(student);
	log.info("Student Update:"+student);
		
	}

	@Override
	public Student getById(long id) {
	Student student=session.get(Student.class, new Long(id));
	log.info("Student Loaded."+student);
		return student;
	}

}
