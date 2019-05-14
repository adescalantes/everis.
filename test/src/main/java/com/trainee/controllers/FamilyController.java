package com.trainee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  @Qualifier("familyServ")
  private FamilyService family;

  @GetMapping("/families")
  public List<Family> getFamilies() {
    return family.getAllFamily();
  }

  @GetMapping("/families/{id}")
  public List<FamilyMember> getFamily(@PathVariable("id") int id) {
    return family.getAllFamilyMembers(id);
  }

  @PostMapping("/families")
  public boolean postFamilies(@RequestBody @Valid Family family) {
    return this.family.postFamily(family);
  }

  @DeleteMapping(value = "/families/{id}")
  public boolean deleteParents(@PathVariable("id") int id) {
    return this.family.deleteFamily(id);
  }
}
