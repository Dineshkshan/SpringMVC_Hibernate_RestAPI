package com.hibernate.Container;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.Dao.StudentDao;
import com.hibernate.model.Student;


@RestController
public class Container 
{
	@Autowired
	private StudentDao student;

	@GetMapping("/getbyid/{id}")
	@ResponseBody
	public Student getById(@PathVariable int id)
	{
		//System.out.println("ID"+id);
		return student.getStudentById(id);
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public List<Student> Getall()
	{
		return student.getall();
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public String InsertStudent(@RequestBody Student stud)
	{
		student.insertStudent(stud);
		return "Student Inserted Successfully";
	}
	
	@PutMapping("/update")
	@ResponseBody
	public String UpdateStudent(@RequestBody Student stud)
	{
		student.updateStudent(stud);
		return "Student Updated Successfully";
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String DeleteStudent(@PathVariable int id)
	{
		student.deleteStudent(id);
		return "Student Deleted Successfully";
	}
}
