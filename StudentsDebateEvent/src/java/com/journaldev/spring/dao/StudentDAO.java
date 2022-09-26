package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Person;

public interface StudentDAO {

	public void addStudent(Student s);
	public void updateStudent(Student s);
	public List<Student> listStudent();
	public Student getStudentById(int id);
	public void removeStudent(int id);
}
