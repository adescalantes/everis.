package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  public ResponseEntity<Parent> postParent(Parent parent) {
	  if(parentRepository.findById(parent.getId())==null) {
			parentRepository.save(parent);
			return new ResponseEntity<Parent>(HttpStatus.OK);
		  }
		  else {
			 return new ResponseEntity<Parent>(HttpStatus.METHOD_NOT_ALLOWED);
		  }

  }

  public ResponseEntity<Parent> putParent(Parent parent) {
	  if(parentRepository.findById(parent.getId())!=null) {
		parentRepository.save(parent);
		return new ResponseEntity<Parent>(HttpStatus.OK);
	  }else {
		  return new ResponseEntity<Parent>(HttpStatus.METHOD_NOT_ALLOWED);
	  }
    
  }

  public void deleteParent(int id) {
    Parent parent = parentRepository.findById(id);
    parentRepository.delete(parent);

  }
}
