package com.trainee.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "student_id")
  private int id;

  @Column(name = "gender")
  private String gender;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Column(name = "other_student_details")
  private String otherStudentDetails;

  @JsonIgnore
  @ManyToMany(mappedBy = "student")
  private Set<Parent> parent;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getOtherStudentDetails() {
    return otherStudentDetails;
  }

  public void setOtherStudentDetails(String otherStudentDetails) {
    this.otherStudentDetails = otherStudentDetails;
  }

  public Set<Parent> getParent() {
    return parent;
  }

  public void setParent(Set<Parent> parent) {
    this.parent = parent;
  }

  public Student(int id, String gender, String firstName, String middleName, String lastName, Date dateOfBirth,
      String otherStudentDetails, Set<Parent> parent) {
    this.id = id;
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.otherStudentDetails = otherStudentDetails;
    this.parent = parent;
  }

  public Student() {
  }

}
