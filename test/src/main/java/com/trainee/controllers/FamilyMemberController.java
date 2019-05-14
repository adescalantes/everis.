package com.trainee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.models.FamilyMember;
import com.trainee.services.FamilyMemberService;

@RestController
@RequestMapping("/v1")
public class FamilyMemberController {

  @Autowired
  @Qualifier("familyMemberServ")
  private FamilyMemberService familyMember;

  @GetMapping("/familyMembers")
  public List<FamilyMember> getFamilies() {
    return familyMember.getAllFamilyMember();
  }
}
