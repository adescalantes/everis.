package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

@Service(value = "parentServ")

public class ParentService {

  @Autowired
  @Qualifier("parentRepo")
  private ParentRepository parent;

  public List<Parent> getAllParent() {
    return parent.findAll();
  }

  public boolean postParent(Parent parent) {
    try {
      this.parent.save(parent);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean putParent(Parent parent) {
    try {
      this.parent.save(parent);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean deleteParent(int id) {
    try {
      Parent parent = this.parent.findById(id);
      this.parent.delete(parent);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
