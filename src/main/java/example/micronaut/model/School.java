package example.micronaut.model;

import java.time.OffsetDateTime;
import java.util.List;

public class School {

  private String name;

  private List<Teacher> teachers;

  private String address;

  private String phoneNumber;

  private OffsetDateTime foundationDate;

  private String founder;

  public School(String name, List<Teacher> teachers) {
    this.name = name;
    this.teachers = teachers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Teacher> getTeachers() {
    return teachers;
  }

  public void setTeachers(List<Teacher> teachers) {
    this.teachers = teachers;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public OffsetDateTime getFoundationDate() {
    return foundationDate;
  }

  public void setFoundationDate(OffsetDateTime foundationDate) {
    this.foundationDate = foundationDate;
  }

  public String getFounder() {
    return founder;
  }

  public void setFounder(String founder) {
    this.founder = founder;
  }
}
