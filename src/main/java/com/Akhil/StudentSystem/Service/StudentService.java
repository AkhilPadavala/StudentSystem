package com.Akhil.StudentSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Akhil.StudentSystem.Model.Student;
import com.Akhil.StudentSystem.Repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	public Student saveStudent(Student s)
	{
		return repo.save(s);
	}
	
	public List<Student> getAllStudents()
	{
		return repo.findAll();
			
	}
	
	public Student updateStudent(Student s)
	{
		return repo.save(s);
	}
	
	public boolean deleteStudentById(int id)
	{
		try {
			repo.deleteById(id);
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
	}
}
		
		
