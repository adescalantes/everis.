package com.trainee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public List<Student> getAll() {
    return studentService.getAll();
  }

  @PostMapping(value = "/students")
  public ResponseEntity<Student> postStudent(@RequestBody @Valid Student student) {
    return studentService.postStudent(student);
  }

  @PutMapping(value = "/students")
  public ResponseEntity<Student> putStudent(@RequestBody @Valid Student student) {
    return studentService.putStudent(student);
  }

  @DeleteMapping(value = "/students/{id}")
  public void deleteStudent(@PathVariable("id") int id) {
    studentService.deleteStudent(id);
  }
}
