package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Studentname;
	private String Studentsubject;
	private int marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public String getStudentsubject() {
		return Studentsubject;
	}
	public void setStudentsubject(String studentsubject) {
		Studentsubject = studentsubject;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(String studentname, String studentsubject, int marks) {
		Studentname = studentname;
		Studentsubject = studentsubject;
		this.marks = marks;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Studentname=" + Studentname + ", Studentsubject=" + Studentsubject + ", marks="
				+ marks + "]";
	}
	
}
