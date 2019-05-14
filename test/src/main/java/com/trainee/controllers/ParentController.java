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

import com.trainee.models.Parent;
import com.trainee.services.ParentService;

@RestController
@RequestMapping("/v1")
public class ParentController {

  @Autowired
  @Qualifier(value = "parentServ")
  private ParentService parent;

  @GetMapping(value = "/parents")
  public List<Parent> getParents() {
    return parent.getAllParent();
  }

  @PostMapping(value = "/parents")
  public boolean postParents(@RequestBody @Valid Parent parent) {
    return this.parent.postParent(parent);
  }

  @PutMapping(value = "/parents")
  public boolean putParents(@RequestBody @Valid Parent parent) {
    return this.parent.putParent(parent);
  }

  @DeleteMapping(value = "/parents/{id}")
  public boolean deleteParents(@PathVariable("id") int id) {
    return this.parent.deleteParent(id);
  }
}
