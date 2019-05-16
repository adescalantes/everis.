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

import com.trainee.models.Parent;
import com.trainee.services.ParentService;

@RestController
@RequestMapping("/v1")
public class ParentController {

  @Autowired
  private ParentService parentService;

  @GetMapping(value = "/parents")
  public List<Parent> getAll() {
    return parentService.getAll();
  }

  @PostMapping(value = "/parents")
  public ResponseEntity<Parent> postParent(@RequestBody @Valid Parent parent) {
    return parentService.postParent(parent);
  }

  @PutMapping(value = "/parents")
  public ResponseEntity<Parent> putParent(@RequestBody @Valid Parent parent) {
    return parentService.putParent(parent);
  }

  @DeleteMapping(value = "/parents/{id}")
  public void deleteParent(@PathVariable("id") int id) {
    parentService.deleteParent(id);
  }
}
