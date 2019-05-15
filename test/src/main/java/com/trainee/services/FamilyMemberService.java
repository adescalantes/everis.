package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  
  public ResponseEntity<FamilyMember> postFamilyMember(FamilyMember familyMember) {
	  if(familyMemberRepository.findById(familyMember.getId())==null) {
		  familyMemberRepository.save(familyMember);
			return new ResponseEntity<FamilyMember>(HttpStatus.OK);
		  }
		  else {
			 return new ResponseEntity<FamilyMember>(HttpStatus.METHOD_NOT_ALLOWED);
		  }

  }

  public ResponseEntity<FamilyMember> putFamilyMember(FamilyMember familyMember) {
	  if(familyMemberRepository.findById(familyMember.getId())!=null) {
		  familyMemberRepository.save(familyMember);
		return new ResponseEntity<FamilyMember>(HttpStatus.OK);
	  }else {
		  return new ResponseEntity<FamilyMember>(HttpStatus.METHOD_NOT_ALLOWED);
	  }
    
  }
  
  public void deleteFamilyMember(int id) {
	  FamilyMember familyMember = familyMemberRepository.findById(id);
	  familyMemberRepository.delete(familyMember);

	  }
}
