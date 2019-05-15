package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.models.FamilyMember;
import com.trainee.repositories.FamilyMemberRepository;

@Service
public class FamilyMemberService {

  @Autowired
  private FamilyMemberRepository familyMemberRepository;

  public List<FamilyMember> getAllFamilyMember() {
    return familyMemberRepository.findAll();
  }
}
