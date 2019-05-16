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

/**
 * Clase para manejar el RestController de Family
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")
public class FamilyController {

  @Autowired
  private FamilyService familyService;

  /**
   * Método GET para obtener todas las Families
   * 
   * @return Todas las Families almacenadas
   */
  @GetMapping("/families")
  public List<Family> getAll() {
    return familyService.getAll();
  }

  /**
   * Método GET para obtener
   * 
   * @param id
   * @return
   */
  @GetMapping("/families/members/{id}")
  public List<FamilyMember> getFamily(@PathVariable("id") int id) {
    return familyService.getFamilyMembers(id);
  }

  @PostMapping("/families")
  public ResponseEntity<Family> postFamily(@RequestBody @Valid Family family) {
    return familyService.postFamily(family);
  }

  @PutMapping("/families")
  public ResponseEntity<Family> putFamily(@RequestBody @Valid Family family) {
    return familyService.putFamily(family);
  }

  @DeleteMapping(value = "/families/{id}")
  public void deleteFamily(@PathVariable("id") int id) {
    familyService.deleteFamily(id);
  }
}
