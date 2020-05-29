package com.hibernate.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.model.Student;


@Repository
@EnableTransactionManagement
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	public List<Student> getall() {
		Session session=sessionfactory.getCurrentSession();
		Query query= session.createQuery("from Student");
		List<Student> student= query.getResultList();
		return student;
	}

	@Transactional
	public Student getStudentById(int id) {
		Session session=sessionfactory.getCurrentSession();
		Student student=session.get(Student.class, id);
		return student;
	}
	
	@Transactional
	public void insertStudent(Student stud) {
		Session session=sessionfactory.getCurrentSession();
		session.save(stud);
	}

	@Transactional
	public void updateStudent(Student Stud) {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("update Student s set s.Studentsubject=?1 where s.id=?2");
		query.setParameter(1,Stud.getStudentsubject());
		query.setParameter(2,Stud.getId());
		query.executeUpdate();
		query.getFirstResult();

	}

	@Transactional
	public void deleteStudent(int id) {
		Session session=sessionfactory.getCurrentSession();
		session.delete(session.get(Student.class, id));

	}

}
