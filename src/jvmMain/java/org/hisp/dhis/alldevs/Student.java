package org.hisp.dhis.alldevs;

import java.util.List;

public record Student(
        String name,
        List<Subject> subjects
) {
    public List<Subject> failedSubjects() {
        return subjects.stream()
                .filter(subject -> subject.values().stream().anyMatch(value -> value < 5))
                .toList();
    }
}
