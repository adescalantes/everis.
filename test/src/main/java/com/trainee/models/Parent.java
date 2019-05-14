package com.trainee.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "parents")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Parent {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "parent_id")
  private int id;

  @Column(name = "gender")
  private String gender;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "other_parent_details")
  private String otherParentDetails;

  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "student_parents", joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
  private Set<Student> student;

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

  public String getOtherParentDetails() {
    return otherParentDetails;
  }

  public void setOtherParentDetails(String otherParentDetails) {
    this.otherParentDetails = otherParentDetails;
  }

  public Set<Student> getStudent() {
    return student;
  }

  public void setStudent(Set<Student> student) {
    this.student = student;
  }

  public Parent(int id, String gender, String firstName, String middleName, String lastName, String otherParentDetails,
      Set<Student> student) {
    this.id = id;
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.otherParentDetails = otherParentDetails;
    this.student = student;
  }

  public Parent() {
  }

}
