package example.micronaut.dto;

import example.micronaut.model.Department;

public class StudentDTO {

  private Integer id;

  private String name;

  private Department department;

  public StudentDTO(String name, Department department) {
    this.name = name;
    this.department = department;
  }

  public StudentDTO(Integer id, String name, Department department) {
    this.name = name;
    this.department = department;
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
