package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trainee.models.FamilyMember;
import com.trainee.repositories.FamilyMemberRepository;

@Service(value = "familyMemberServ")
public class FamilyMemberService {

  @Autowired
  @Qualifier("familyMemberRepo")
  private FamilyMemberRepository familyMember;

  public List<FamilyMember> getAllFamilyMember() {
    return familyMember.findAll();
  }
}
