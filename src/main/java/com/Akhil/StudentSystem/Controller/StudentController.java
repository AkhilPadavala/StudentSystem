package com.Akhil.StudentSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Akhil.StudentSystem.Model.Student;
import com.Akhil.StudentSystem.Service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("add")
	public ResponseEntity<Student> saveStudent(@RequestBody Student s)
	{
		 Student s1=service.saveStudent(s);
		 if(s1!=null)
		 {
		 return new ResponseEntity<Student>(HttpStatus.CREATED);
		 }
		 else
		 {
			 return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		 }
		
	}
	@GetMapping("getAll")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student>l=service.getAllStudents();
		if(l.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
			return ResponseEntity.of(Optional.of(l));
		}
		
	}
	
	@PatchMapping("update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s)
	{
		Student s2=service.updateStudent(s);
		if(s2!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		boolean s=service.deleteStudentById(id);
		if(s)
		{
  		  return ResponseEntity.of(Optional.of("SUCCESSFULLY DELETED"));
		}
		else 
		{
  		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }
		
	}

}
