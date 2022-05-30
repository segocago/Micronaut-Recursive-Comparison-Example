package example.micronaut;

import example.micronaut.dto.SchoolDTO;
import example.micronaut.dto.TeacherDTO;
import example.micronaut.model.Department;
import example.micronaut.model.School;
import example.micronaut.model.Teacher;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class RecursiveComparisonExampleTests {

  @Test
  public void testSimpleRecursiveComparison() {

    List<Teacher> teacherList1 = List.of(
        new Teacher("Cagatay", Department.MATH),
        new Teacher("Alex", Department.CHEMISTRY));

    List<Teacher> teacherList2 = List.of(
        new Teacher("Cagatay", Department.MATH),
        new Teacher("Alex", Department.CHEMISTRY));

    School school1 = new School("PTA Primary School", teacherList1);
    School school2 = new School("PTA Primary School", teacherList2);

    assertThat(school1).usingRecursiveComparison().isEqualTo(school2);
  }

  @Test
  public void testRecursiveComparisonWithDifferentObjects() {

    List<Teacher> teachers = List.of(
        new Teacher("Cagatay", Department.MATH),
        new Teacher("Alex", Department.CHEMISTRY));

    List<TeacherDTO> teacherDTOs = List.of(
        new TeacherDTO("Cagatay", Department.MATH),
        new TeacherDTO("Alex", Department.CHEMISTRY));

    School school = new School("PTA Primary School", teachers);
    SchoolDTO schoolDTO = new SchoolDTO("PTA Primary School", teacherDTOs);

    assertThat(school).usingRecursiveComparison().isEqualTo(schoolDTO);
  }

  @Test
  public void testRecursiveComparisonWithIgnoredFields() {

    List<Teacher> teachers = List.of(
        new Teacher(1, "Cagatay", Department.MATH),
        new Teacher(2, "Alex", Department.CHEMISTRY));

    List<TeacherDTO> teachersWithIds = List.of(
        new TeacherDTO("Cagatay", Department.MATH),
        new TeacherDTO("Alex", Department.CHEMISTRY));

    School school = new School("PTA Primary School", teachers);
    SchoolDTO schoolDTO = new SchoolDTO("PTA Primary School", teachersWithIds);

    //This that fails since one one teacher list does not have id set while the other teacher list have id fields set
    assertThat(school).usingRecursiveComparison().isNotEqualTo(schoolDTO);

    //We can reference the fields of nested objects with ignoringFields() method
    assertThat(school).usingRecursiveComparison().ignoringFields("teachers.id").isEqualTo(schoolDTO);
  }
}
