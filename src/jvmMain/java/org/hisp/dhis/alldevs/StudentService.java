package org.hisp.dhis.alldevs;

import java.util.List;

public class StudentService {

    public List<String> getStudentsWithFailedSubjects(List<Student> students) {
        return students.stream()
                .filter(s -> !s.failedSubjects().isEmpty())
                .map(Student::name)
                .toList();
    }
}
