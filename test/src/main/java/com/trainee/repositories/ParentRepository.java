package com.trainee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Parent;

@Repository(value = "parentRepo")
public interface ParentRepository extends JpaRepository<Parent, Integer> {

  public Parent findById(int id);
}
