package com.hibernate.Dao;

import java.util.List;

import com.hibernate.model.Student;

public interface StudentDao {

	public List<Student> getall();
	public Student getStudentById(int id);
	public void insertStudent(Student stud);
	public void updateStudent(Student stud);
	public void deleteStudent(int id);
}
