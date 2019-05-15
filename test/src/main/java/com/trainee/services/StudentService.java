package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  public void postStudent(Student student) {

    studentRepository.save(student);
  }

  public void deleteStudent(int id) {
    Student student = studentRepository.findById(id);
    studentRepository.delete(student);

  }
}
