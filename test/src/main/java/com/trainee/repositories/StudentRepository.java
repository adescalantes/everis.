package com.trainee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Student;

@Repository(value = "studentRepo")
public interface StudentRepository extends JpaRepository<Student, Integer> {

  public Student findById(int id);
}
