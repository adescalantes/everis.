package com.trainee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trainee.models.Family;
import com.trainee.models.FamilyMember;
import com.trainee.models.Student;
import com.trainee.repositories.FamilyMemberRepository;
import com.trainee.repositories.FamilyRepository;

@Service
public class FamilyService {

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private FamilyMemberRepository familyMemberRepository;

  public List<Family> getAllFamily() {
    return familyRepository.findAll();
  }

  public List<FamilyMember> getAllFamilyMembers(int id) {
    return familyMemberRepository.findByFamilyId(id);
  }

  public ResponseEntity<Family> postFamily(Family family) {
	  if(familyRepository.findById(family.getId())==null) {
		  familyRepository.save(family);
			return new ResponseEntity<Family>(HttpStatus.OK);
		  }
		  else {
			 return new ResponseEntity<Family>(HttpStatus.METHOD_NOT_ALLOWED);
		  }

  }

  public ResponseEntity<Family> putFamily(Family family) {
	  if(familyRepository.findById(family.getId())!=null) {
		  familyRepository.save(family);
		return new ResponseEntity<Family>(HttpStatus.OK);
	  }else {
		  return new ResponseEntity<Family>(HttpStatus.METHOD_NOT_ALLOWED);
	  }
    
  }

  public void deleteFamily(int id) {
    Family family = familyRepository.findById(id);
    familyRepository.delete(family);

  }
}
