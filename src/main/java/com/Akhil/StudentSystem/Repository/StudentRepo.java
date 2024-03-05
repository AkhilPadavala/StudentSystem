package com.Akhil.StudentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Akhil.StudentSystem.Model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	

}
