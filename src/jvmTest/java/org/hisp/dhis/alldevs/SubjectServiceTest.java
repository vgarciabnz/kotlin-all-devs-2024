package org.hisp.dhis.alldevs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectServiceTest {

    private final SubjectService service = new SubjectService();

    @Test
    public void testGetSubjectWithHighestValue() {
        List<Subject> subjects = List.of(
                new Subject("Math", List.of(1, 3)),
                new Subject("Biology", List.of(12, 34)),
                new Subject("Literature", List.of(12, 21))
        );

        String subjectName = service.getSubjectWithHighestValue(subjects);

        assertEquals(subjectName, "Biology");
    }
}
