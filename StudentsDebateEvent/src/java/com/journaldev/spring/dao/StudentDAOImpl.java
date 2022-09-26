package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStudent(Student s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Student saved successfully, Student Details="+s);
	}

	@Override
	public void updateStudent(Student s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
		logger.info("Student updated successfully, Student Details="+s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentsList = session.createQuery("from Student").list();
		for(Student s : studentsList){
			logger.info("Student List::"+s);
		}
		return studentsList;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Student s = (Student) session.load(Student.class, new Integer(id));
		logger.info("Student loaded successfully, Student details="+s);
		return p;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student s = (Student) session.load(Student.class, new Integer(id));
		if(null != s){
			session.delete(s);
		}
		logger.info("Student deleted successfully, student details="+s);
	}

}
