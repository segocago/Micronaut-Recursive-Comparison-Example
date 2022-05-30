package example.micronaut.dto;

import java.util.List;

public class SchoolDTO {

  private String name;

  private List<TeacherDTO> teacher;

  public SchoolDTO(String name, List<TeacherDTO> teacher) {
    this.name = name;
    this.teacher = teacher;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TeacherDTO> getTeacher() {
    return teacher;
  }

  public void setTeacher(List<TeacherDTO> teacherDTO) {
    this.teacher = teacherDTO;
  }
}
