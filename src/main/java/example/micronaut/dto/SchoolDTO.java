package example.micronaut.dto;

import java.util.List;

public class SchoolDTO {

  private String name;

  private List<StudentDTO> students;

  private String address;

  private String phoneNumber;

  private String foundationDate;

  private String founder;

  public SchoolDTO(String name, List<StudentDTO> students) {
    this.name = name;
    this.students = students;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<StudentDTO> getStudents() {
    return students;
  }

  public void setStudents(List<StudentDTO> students) {
    this.students = students;
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

  public String getFoundationDate() {
    return foundationDate;
  }

  public void setFoundationDate(String foundationDate) {
    this.foundationDate = foundationDate;
  }

  public String getFounder() {
    return founder;
  }

  public void setFounder(String founder) {
    this.founder = founder;
  }
}
