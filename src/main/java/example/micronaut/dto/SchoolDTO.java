package example.micronaut.dto;

import java.util.List;

public class SchoolDTO {

  private String name;

  private List<TeacherDTO> teachers;

  public SchoolDTO(String name, List<TeacherDTO> teachers) {
    this.name = name;
    this.teachers = teachers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TeacherDTO> getTeachers() {
    return teachers;
  }

  public void setTeachers(List<TeacherDTO> teacherDTO) {
    this.teachers = teacherDTO;
  }
}
