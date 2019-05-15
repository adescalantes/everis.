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


import com.trainee.models.FamilyMember;
import com.trainee.services.FamilyMemberService;

@RestController
@RequestMapping("/v1")
public class FamilyMemberController {

  @Autowired
  private FamilyMemberService familyMemberService;

  @GetMapping("/familyMembers")
  public List<FamilyMember> getFamilies() {
    return familyMemberService.getAllFamilyMember();
  }
  
  @PostMapping("/familyMembers")
  public ResponseEntity<FamilyMember> postFamilies(@RequestBody @Valid FamilyMember familyMember) {
    return familyMemberService.postFamilyMember(familyMember);
  }
  
  @PutMapping("/familyMembers")
  public ResponseEntity<FamilyMember> putFamilies(@RequestBody @Valid FamilyMember familyMember) {
	 return familyMemberService.putFamilyMember(familyMember);
  }
  
  @DeleteMapping(value = "/familyMembers/{id}")
  public void deleteParents(@PathVariable("id") int id) {
	  familyMemberService.deleteFamilyMember(id);
  }

}
