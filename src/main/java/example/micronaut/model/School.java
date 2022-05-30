package example.micronaut.model;

import java.util.List;

public class School {

  private String name;

  private List<Teacher> teachers;

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
}
