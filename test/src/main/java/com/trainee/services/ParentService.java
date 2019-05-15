package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

@Service

public class ParentService {

  @Autowired
  private ParentRepository parentRepository;

  public List<Parent> getAllParent() {
    return parentRepository.findAll();
  }

  public void postParent(Parent parent) {

    parentRepository.save(parent);

  }

  public void putParent(Parent parent) {

    parentRepository.save(parent);

  }

  public void deleteParent(int id) {
    Parent parent = parentRepository.findById(id);
    parentRepository.delete(parent);

  }
}
