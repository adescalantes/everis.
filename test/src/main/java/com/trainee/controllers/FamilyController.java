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

import com.trainee.models.Family;
import com.trainee.models.FamilyMember;
import com.trainee.services.FamilyService;

@RestController
@RequestMapping("/v1")
public class FamilyController {

  @Autowired
  private FamilyService familyService;

  @GetMapping("/families")
  public List<Family> getFamilies() {
    return familyService.getAllFamily();
  }

  @GetMapping("/families/members/{id}")
  public List<FamilyMember> getFamily(@PathVariable("id") int id) {
    return familyService.getAllFamilyMembers(id);
  }

  @PostMapping("/families")
  public ResponseEntity<Family> postFamilies(@RequestBody @Valid Family family) {
    return familyService.postFamily(family);
  }
  
  @PutMapping("/families")
  public ResponseEntity<Family> putFamilies(@RequestBody @Valid Family family) {
	 return familyService.putFamily(family);
  }

  @DeleteMapping(value = "/families/{id}")
  public void deleteFamilies(@PathVariable("id") int id) {
    familyService.deleteFamily(id);
  }
}
