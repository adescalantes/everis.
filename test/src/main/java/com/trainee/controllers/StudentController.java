package com.trainee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
  private StudentService studentService;

  @GetMapping(value = "/students")
  public List<Student> getParents() {
    return studentService.getAllStudent();
  }

  @PostMapping(value = "/students")
  public void postParents(@RequestBody @Valid Student student) {
    studentService.postStudent(student);
  }

  @PutMapping(value = "/students")
  public void putParents(@RequestBody @Valid Student student) {
    studentService.postStudent(student);
  }

  @DeleteMapping(value = "/students/{id}")
  public void deleteParents(@PathVariable("id") int id) {
    studentService.deleteStudent(id);
  }
}
