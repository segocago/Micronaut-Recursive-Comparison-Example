package example.micronaut;

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
}
