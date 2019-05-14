package com.trainee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.models.Student;
import com.trainee.services.StudentService;

@RestController
@RequestMapping("/v1")
public class StudentController {

  @Autowired
  @Qualifier(value = "studentServ")
  private StudentService student;

  @GetMapping(value = "/students")
  public List<Student> getParents() {
    return student.getAllStudent();
  }

  @PostMapping(value = "/students")
  public boolean postParents(@RequestBody @Valid Student student) {
    return this.student.postStudent(student);
  }

  @PutMapping(value = "/students")
  public boolean putParents(@RequestBody @Valid Student student) {
    return this.student.postStudent(student);
  }

  @DeleteMapping(value = "/students/{id}")
  public boolean deleteParents(@PathVariable("id") int id) {
    return this.student.deleteStudent(id);
  }
}
