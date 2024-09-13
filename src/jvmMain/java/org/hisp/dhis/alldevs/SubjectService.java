package org.hisp.dhis.alldevs;

import java.util.Comparator;
import java.util.List;

public class SubjectService {

    public String getSubjectWithHighestValue(List<Subject> subjects) {
        Subject maxSubject = null;
        Integer maxValue = null;

        for (Subject subject : subjects) {
            Integer maxSubjectValue = getSubjectMaxValue(subject);
            if (maxValue == null || (maxSubjectValue != null && maxSubjectValue > maxValue)) {
                maxValue = maxSubjectValue;
                maxSubject = subject;
            }
        }

        return maxSubject == null ? null : maxSubject.name();
    }

    private Integer getSubjectMaxValue(Subject subject) {
        return subject.values().stream()
                .max(Comparator.comparingInt(a -> a))
                .orElse(null);

    }
}
