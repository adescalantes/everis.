package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudent() {
	    return studentRepository.findAll();
	  }

  public ResponseEntity<Student> postStudent(Student student) {
	  if(studentRepository.findById(student.getId())==null) {
		  studentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		  }
		  else {
			 return new ResponseEntity<Student>(HttpStatus.METHOD_NOT_ALLOWED);
		  }

  }

  public ResponseEntity<Student> putStudent(Student student) {
	  if(studentRepository.findById(student.getId())!=null) {
		  studentRepository.save(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
	  }else {
		  return new ResponseEntity<Student>(HttpStatus.METHOD_NOT_ALLOWED);
	  }
    
  }

  public void deleteStudent(int id) {
    Student student = studentRepository.findById(id);
    studentRepository.delete(student);

  }
}
