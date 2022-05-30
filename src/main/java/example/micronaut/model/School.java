package example.micronaut.model;

import java.util.List;

public class School {

  private String name;

  private List<Teacher> teacher;

  public School(String name, List<Teacher> teacher) {
    this.name = name;
    this.teacher = teacher;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Teacher> getTeacher() {
    return teacher;
  }

  public void setTeacher(List<Teacher> teacher) {
    this.teacher = teacher;
  }
}
