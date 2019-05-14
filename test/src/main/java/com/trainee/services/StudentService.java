package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;

@Service(value = "studentServ")
public class StudentService {

  @Autowired
  @Qualifier("studentRepo")
  private StudentRepository student;

  public List<Student> getAllStudent() {
    return student.findAll();
  }

  public boolean postStudent(Student student) {
    try {
      this.student.save(student);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean deleteStudent(int id) {
    try {
      Student student = this.student.findById(id);
      this.student.delete(student);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
