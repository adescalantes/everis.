package com.trainee.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "family_members")
public class FamilyMember {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "family_member_id")
  private int id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "family_id", referencedColumnName = "family_id")
  private Family family;

  @Column(name = "parent_or_studen_member")
  private String parentOrStudent;

  @OneToOne
  @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
  private Parent parent;

  @OneToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }

  public String getParentOrStudent() {
    return parentOrStudent;
  }

  public void setParentOrStudent(String parentOrStudent) {
    this.parentOrStudent = parentOrStudent;
  }

  public Parent getParent() {
    return parent;
  }

  public void setParent(Parent parent) {
    this.parent = parent;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public FamilyMember(int id, @NotNull Family family, String parentOrStudent, Parent parent, Student student) {
    this.id = id;
    this.family = family;
    this.parentOrStudent = parentOrStudent;
    this.parent = parent;
    this.student = student;
  }

  public FamilyMember() {
  }
}
