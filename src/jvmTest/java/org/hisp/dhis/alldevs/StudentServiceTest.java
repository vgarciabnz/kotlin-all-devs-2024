package org.hisp.dhis.alldevs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {

    private final StudentService service = new StudentService();

    @Test
    public void testGetStudentsWithFailedSubjects() {
        List<Student> students = List.of(
                new Student(
                        "John",
                        List.of(
                                new Subject("Math", List.of(6, 5)),
                                new Subject("Biology", List.of(3, 8))
                        )
                ),
                new Student(
                        "Mark",
                        List.of(
                                new Subject("Math", List.of(7, 5)),
                                new Subject("Biology", List.of(7, 8))
                        )
                )
        );

        List<String> failedStudents = service.getStudentsWithFailedSubjects(students);

        assertEquals(failedStudents, List.of("John"));
    }
}
