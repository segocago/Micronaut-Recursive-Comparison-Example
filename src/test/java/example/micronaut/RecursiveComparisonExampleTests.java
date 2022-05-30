package example.micronaut;

import example.micronaut.dto.SchoolDTO;
import example.micronaut.dto.StudentDTO;
import example.micronaut.model.Department;
import example.micronaut.model.School;
import example.micronaut.model.Student;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class RecursiveComparisonExampleTests {

  @Test
  public void testComparisonWithoutRecursiveComparisonAPI() {

    List<Student> studentList1 = List.of(
        new Student("Cagatay", Department.MATH),
        new Student("Alex", Department.CHEMISTRY));

    List<Student> studentList2 = List.of(
        new Student("Cagatay", Department.MATH),
        new Student("Alex", Department.CHEMISTRY));

    School school1 = new School("PTA Primary School", studentList1);
    School school2 = new School("PTA Primary School", studentList2);

    assertEquals(school2.getName(), school1.getName());
    assertEquals(school2.getAddress(), school1.getAddress());
    assertEquals(school2.getPhoneNumber(), school1.getPhoneNumber());
    assertEquals(school2.getFounder(), school1.getFounder());
    assertEquals(school2.getFoundationDate(), school1.getFoundationDate());
    for (int i = 0; i < school2.getTeachers().size(); i++) {
      assertEquals(school2.getTeachers().get(i).getName(), school1.getTeachers().get(i).getName());
      assertEquals(school2.getTeachers().get(i).getDepartment(), school1.getTeachers().get(i).getDepartment());
    }
    // And the fields continue and the test gets bigger as more field is added
  }

  @Test
  public void testSimpleRecursiveComparison() {

    List<Student> studentList1 = List.of(
        new Student("Cagatay", Department.MATH),
        new Student("Alex", Department.CHEMISTRY));

    List<Student> studentList2 = List.of(
        new Student("Cagatay", Department.MATH),
        new Student("Alex", Department.CHEMISTRY));

    School school1 = new School("PTA Primary School", studentList1);
    School school2 = new School("PTA Primary School", studentList2);

    assertThat(school1).usingRecursiveComparison().isEqualTo(school2);
  }

  @Test
  public void testRecursiveComparisonWithDifferentObjects() {

    List<Student> students = List.of(
        new Student("Cagatay", Department.MATH),
        new Student("Alex", Department.CHEMISTRY));

    List<StudentDTO> studentDTOs = List.of(
        new StudentDTO("Cagatay", Department.MATH),
        new StudentDTO("Alex", Department.CHEMISTRY));

    School school = new School("PTA Primary School", students);
    SchoolDTO schoolDTO = new SchoolDTO("PTA Primary School", studentDTOs);

    assertThat(school).usingRecursiveComparison().isEqualTo(schoolDTO);
  }

  @Test
  public void testRecursiveComparisonWithIgnoredFields() {

    List<Student> students = List.of(
        new Student(1, "Cagatay", Department.MATH),
        new Student(2, "Alex", Department.CHEMISTRY));

    List<StudentDTO> studentDTOs = List.of(
        new StudentDTO("Cagatay", Department.MATH),
        new StudentDTO("Alex", Department.CHEMISTRY));

    School school = new School("PTA Primary School", students);
    SchoolDTO schoolDTO = new SchoolDTO("PTA Primary School", studentDTOs);

    //This that fails since one teacher list does not have id set while the other teacher list have id fields set
    assertThat(school).usingRecursiveComparison().isNotEqualTo(schoolDTO);

    //We can reference the fields of nested objects with ignoringFields() method
    assertThat(school).usingRecursiveComparison().ignoringFields("teachers.id").isEqualTo(schoolDTO);
  }
}
